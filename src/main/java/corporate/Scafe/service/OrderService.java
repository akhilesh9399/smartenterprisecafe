package corporate.Scafe.service;


import corporate.Scafe.dto.CreateOrderRequest;
import corporate.Scafe.entity.Orders;

import java.util.List;

public interface OrderService {

    String createOrder(CreateOrderRequest request);
    List<Orders> getEmployeeOrders(Long employeeId);
    Orders getOrderDetails(Long orderId);
}
