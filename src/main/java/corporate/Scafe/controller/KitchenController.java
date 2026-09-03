package corporate.Scafe.controller;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kitchen/orders")
@RequiredArgsConstructor
public class KitchenController {

    private final KitchenService kitchenService;

    @PutMapping("/{orderId}/accept")
    public String acceptOrder(
            @PathVariable Long orderId) {

        return kitchenService.acceptOrder(orderId);
    }

    @PutMapping("/{orderId}/prepare")
    public String prepareOrder(
            @PathVariable Long orderId) {

        return kitchenService.startPreparing(orderId);
    }

    @PutMapping("/{orderId}/ready")
    public String readyOrder(
            @PathVariable Long orderId) {

        return kitchenService.markReady(orderId);
    }

    @PutMapping("/{orderId}/deliver")
    public String deliverOrder(
            @PathVariable Long orderId) {

        return kitchenService.markDelivered(orderId);
    }
    @GetMapping("/{kitchenId}")
    public List<Orders> getKitchenOrders(
            @PathVariable Long kitchenId
    ) {
        return kitchenService.getKitchenOrders(kitchenId);
    }
}