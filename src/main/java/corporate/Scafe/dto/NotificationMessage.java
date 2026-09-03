package corporate.Scafe.dto;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {

    private Long orderId;
    private String orderNumber;
    private String message;
    private String status;
}