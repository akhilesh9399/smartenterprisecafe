package corporate.Scafe.service;

import corporate.Scafe.entity.Orders;

import java.util.List;

public interface KitchenService {

    String acceptOrder(Long orderId);
    String startPreparing(Long orderId);
    String markReady(Long orderId);
    String markDelivered(Long orderId);
    List<Orders> getKitchenOrders(Long kitchenId);
}