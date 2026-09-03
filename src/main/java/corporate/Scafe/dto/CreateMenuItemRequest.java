package corporate.Scafe.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateMenuItemRequest {

    private String itemName;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private Long kitchenId;

}