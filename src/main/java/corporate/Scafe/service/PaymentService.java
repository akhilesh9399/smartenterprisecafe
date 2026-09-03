package corporate.Scafe.service;


import corporate.Scafe.dto.CreatePaymentRequest;
import corporate.Scafe.dto.PaymentResponse;
import corporate.Scafe.dto.VerifyPaymentRequest;

public interface PaymentService {

    PaymentResponse createPayment(
            CreatePaymentRequest request
    ) throws Exception;

    String verifyPayment(
            VerifyPaymentRequest request
    ) throws Exception;
}
