package corporate.Scafe.serviceImpl;



import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import corporate.Scafe.dto.CreatePaymentRequest;
import corporate.Scafe.dto.PaymentResponse;
import corporate.Scafe.dto.VerifyPaymentRequest;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.entity.Payment;
import corporate.Scafe.enums.OrderStatus;
import corporate.Scafe.enums.PaymentMode;
import corporate.Scafe.enums.PaymentStatus;
import corporate.Scafe.exception.custom.BadRequestException;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.OrderRepository;
import corporate.Scafe.repository.PaymentRepository;
import corporate.Scafe.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final RazorpayClient razorpayClient;

    private final OrderRepository orderRepository;

    private final PaymentRepository paymentRepository;

    @Value("${razorpay.key.id}")
    private String razorpayKey;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;


    @Override
    public PaymentResponse createPayment(
            CreatePaymentRequest request
    ) throws Exception {

        Orders order = orderRepository.findById(
                        request.getOrderId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order Not Found"
                        ));

        JSONObject options = new JSONObject();

        options.put(
                "amount",
                order.getTotalAmount()
                        .multiply(java.math.BigDecimal.valueOf(100))
                        .longValue()
        );

        options.put("currency", "INR");

        options.put("receipt",
                order.getOrderNumber()
        );

        Order razorpayOrder =
                razorpayClient.orders.create(options);

        Payment payment = Payment.builder()
                .order(order)
                .amount(order.getTotalAmount())
                .paymentMode(PaymentMode.RAZORPAY)
                .paymentStatus(PaymentStatus.PENDING)
                .razorpayOrderId(
                        razorpayOrder.get("id")
                                .toString()
                )
                .build();

        paymentRepository.save(payment);

        return PaymentResponse.builder()
                .razorpayOrderId(
                        razorpayOrder.get("id")
                                .toString()
                )
                .key(razorpayKey)
                .amount(
                        order.getTotalAmount()
                                .doubleValue()
                )
                .build();
    }

    @Override
    public String verifyPayment(
            VerifyPaymentRequest request
    ) throws Exception {

        String payload =
                request.getRazorpayOrderId()
                        + "|"
                        + request.getRazorpayPaymentId();

        boolean isValid = Utils.verifySignature(
                payload,
                request.getRazorpaySignature(),
                razorpaySecret
        );

        if (!isValid) {

            throw new BadRequestException(
                    "Invalid Razorpay Signature"
            );
        }

        Payment payment =
                paymentRepository.findAll()
                        .stream()
                        .filter(p ->
                                p.getRazorpayOrderId()
                                        .equals(
                                                request.getRazorpayOrderId()
                                        ))
                        .findFirst()
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Payment Not Found"
                                )
                        );

        payment.setPaymentStatus(
                PaymentStatus.SUCCESS
        );

        payment.setRazorpayPaymentId(
                request.getRazorpayPaymentId()
        );

        payment.setPaymentDate(
                LocalDateTime.now()
        );

        paymentRepository.save(payment);

        Orders order = payment.getOrder();

        order.setStatus(
                OrderStatus.PAYMENT_SUCCESS
        );

        orderRepository.save(order);

        return "Payment Verified Successfully";
    }
}