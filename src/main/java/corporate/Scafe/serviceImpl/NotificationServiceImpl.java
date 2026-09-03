package corporate.Scafe.serviceImpl;



import corporate.Scafe.dto.NotificationMessage;
import corporate.Scafe.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl
        implements NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendOrderNotification(
            Long orderId,
            String orderNumber,
            String status,
            String message
    ) {

        NotificationMessage notification =
                NotificationMessage.builder()
                        .orderId(orderId)
                        .orderNumber(orderNumber)
                        .status(status)
                        .message(message)
                        .build();

        messagingTemplate.convertAndSend(
                "/topic/orders",
                notification
        );
    }
}