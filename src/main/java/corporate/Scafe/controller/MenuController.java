package corporate.Scafe.controller;

import corporate.Scafe.dto.CreateCategoryRequest;
import corporate.Scafe.dto.CreateMenuItemRequest;
import corporate.Scafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/category")
    public String createCategory(
            @RequestBody CreateCategoryRequest request
    ) {
        return menuService.createCategory(request);
    }

    @PostMapping("/item")
    public String createMenuItem(
            @RequestBody CreateMenuItemRequest request
    ) {
        return menuService.createMenuItem(request);
    }
}