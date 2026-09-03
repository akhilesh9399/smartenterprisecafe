package corporate.Scafe.dto;

import lombok.Data;
import java.util.List;


@Data
public class CreateOrderRequest {

    private Long employeeId;
    private Long kitchenId;
    private List<OrderItemRequest> items;

}