package corporate.Scafe.controller;

import corporate.Scafe.dto.CreateOrderRequest;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee/orders")
@RequiredArgsConstructor
public class OrderController {

private final OrderService orderService;

@PostMapping
public String createOrder(
@RequestBody CreateOrderRequest request
) {
return orderService.createOrder(request);
}

@GetMapping("/employee/{employeeId}")
public List<Orders> getEmployeeOrders(
@PathVariable Long employeeId
) {
return orderService.getEmployeeOrders(employeeId);
}

@GetMapping("/{orderId}")
public Orders getOrderById(
@PathVariable Long orderId
) {
return orderService.getOrderDetails(orderId);
}
}