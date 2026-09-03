package corporate.Scafe.serviceImpl;

import corporate.Scafe.dto.CreateCategoryRequest;
import corporate.Scafe.dto.CreateMenuItemRequest;
import corporate.Scafe.entity.MenuCategory;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.MenuCategoryRepository;
import corporate.Scafe.repository.MenuItemRepository;
import corporate.Scafe.service.MenuService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import corporate.Scafe.entity.MenuItem;

@Builder
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuCategoryRepository categoryRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public String createCategory(CreateCategoryRequest request) {

        MenuCategory category = MenuCategory.builder()
                .categoryName(request.getCategoryName())
                .active(true)
                .build();

        categoryRepository.save(category);

        return "Category Created Successfully";
    }

    @Override
    public String createMenuItem(CreateMenuItemRequest request) {


        MenuCategory category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category Not Found"
                        ));

        MenuItem menuItem = MenuItem.builder()
                .itemName(request.getItemName())
                .description(request.getDescription())
                .price(request.getPrice())
                .available(true)
                .category(category)
                .build();

        menuItemRepository.save(menuItem);

        return "Menu Item Created Successfully";
    }
}