package corporate.Scafe.serviceImpl;



import corporate.Scafe.entity.Kitchen;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.enums.OrderStatus;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.KitchenRepository;
import corporate.Scafe.repository.OrderRepository;
import corporate.Scafe.service.KitchenService;
import corporate.Scafe.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final NotificationService notificationService;
    private final OrderRepository orderRepository;
    private final KitchenRepository kitchenRepository;

    @Override
    public String acceptOrder(Long orderId) {

        Orders order = getOrder(orderId);

        order.setStatus(OrderStatus.ACCEPTED);

        orderRepository.save(order);
        notificationService.sendOrderNotification(
                order.getId(),
                order.getOrderNumber(),
                "ACCEPTED",
                "Order Accepted By Kitchen"
        );

        return "Order Accepted";
    }

    @Override
    public String startPreparing(Long orderId) {

        Orders order = getOrder(orderId);

        order.setStatus(OrderStatus.PREPARING);

        orderRepository.save(order);
        notificationService.sendOrderNotification(
                order.getId(),
                order.getOrderNumber(),
                "PREPARING",
                "Order Is Being Prepared"
        );

        return "Order Preparing";
    }

    @Override
    public String markReady(Long orderId) {

        Orders order = getOrder(orderId);

        order.setStatus(OrderStatus.READY);

        orderRepository.save(order);
        notificationService.sendOrderNotification(
                order.getId(),
                order.getOrderNumber(),
                "READY",
                "Order Ready For Pickup"
        );
        return "Order Ready";
    }

    @Override
    public String markDelivered(Long orderId) {

        Orders order = getOrder(orderId);

        order.setStatus(OrderStatus.DELIVERED);

        orderRepository.save(order);
        notificationService.sendOrderNotification(
                order.getId(),
                order.getOrderNumber(),
                "READY",
                "Order Ready For Pickup"
        );

        return "Order Delivered";
    }

    private Orders getOrder(Long orderId) {

        return orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order Not Found"
                        ));
    }
    @Override
    public List<Orders> getKitchenOrders(Long kitchenId) {

        Kitchen kitchen = kitchenRepository
                .findById(kitchenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Kitchen Not Found"
                        ));

        return orderRepository.findByKitchen(kitchen);
    }

}