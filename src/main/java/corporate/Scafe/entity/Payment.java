package corporate.Scafe.entity;


import corporate.Scafe.enums.PaymentMode;
import corporate.Scafe.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String transactionId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;
}