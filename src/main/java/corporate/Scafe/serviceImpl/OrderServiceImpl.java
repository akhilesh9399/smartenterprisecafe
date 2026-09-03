package corporate.Scafe.serviceImpl;

import corporate.Scafe.entity.MenuItem;
import corporate.Scafe.entity.*;
import corporate.Scafe.dto.CreateOrderRequest;
import corporate.Scafe.dto.OrderItemRequest;
import corporate.Scafe.enums.OrderStatus;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.*;
import corporate.Scafe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final UserRepository userRepository;
    private final KitchenRepository kitchenRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public String createOrder(CreateOrderRequest request) {

        User employee = userRepository.findById(
                        request.getEmployeeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee Not Found"));

        Kitchen kitchen = kitchenRepository.findById(
                        request.getKitchenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Kitchen Not Found"));

        BigDecimal totalAmount = BigDecimal.ZERO;

        Orders order = Orders.builder()
                .employee(employee)
                .kitchen(kitchen)
                .status(OrderStatus.PAYMENT_PENDING)
                .orderTime(LocalDateTime.now())
                .orderNumber(generateOrderNumber())
                .build();

        Orders savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest itemRequest : request.getItems()) {

            MenuItem menuItem = menuItemRepository
                    .findById(itemRequest.getMenuItemId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Menu Item Not Found"));

            BigDecimal itemPrice =
                    menuItem.getPrice().multiply(
                            BigDecimal.valueOf(
                                    itemRequest.getQuantity()));

            totalAmount = totalAmount.add(itemPrice);

            OrderItem orderItem = OrderItem.builder()
                    .order(savedOrder)
                    .menuItem(menuItem)
                    .quantity(itemRequest.getQuantity())
                    .price(itemPrice)
                    .build();

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        savedOrder.setTotalAmount(totalAmount);
        savedOrder.setOrderItems(orderItems);

        orderRepository.save(savedOrder);

        return "Order Created Successfully. Order Number : "
                + savedOrder.getOrderNumber();
    }

    private String generateOrderNumber() {

        return "CAF-"
                + System.currentTimeMillis();
    }

    @Override
    public List<Orders> getEmployeeOrders(Long employeeId) {

        User employee = userRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee Not Found"
                        ));

        return orderRepository.findByEmployee(employee);
    }

    @Override
    public Orders getOrderDetails(Long orderId) {

        return orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order Not Found"
                        ));
    }
}