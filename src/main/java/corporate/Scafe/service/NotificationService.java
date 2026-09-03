package corporate.Scafe.service;



public interface NotificationService {
    void sendOrderNotification(
            Long orderId,
            String orderNumber,
            String status,
            String message
    );
}