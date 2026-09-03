package corporate.Scafe.dto;

import lombok.Data;

@Data
public class VerifyPaymentRequest {

    private Long orderId;
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
}