package corporate.Scafe.controller;



import corporate.Scafe.dto.CreatePaymentRequest;
import corporate.Scafe.dto.PaymentResponse;
import corporate.Scafe.dto.VerifyPaymentRequest;
import corporate.Scafe.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public PaymentResponse createPayment(
            @RequestBody CreatePaymentRequest request
    ) throws Exception {

        return paymentService.createPayment(
                request
        );
    }

    @PostMapping("/verify")
    public String verifyPayment(
            @RequestBody VerifyPaymentRequest request
    ) throws Exception {

        return paymentService.verifyPayment(
                request
        );
    }
}