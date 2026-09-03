package corporate.Scafe.service;


import corporate.Scafe.dto.CreateCategoryRequest;
import corporate.Scafe.dto.CreateMenuItemRequest;

public interface MenuService {

    String createCategory(CreateCategoryRequest request);

    String createMenuItem(CreateMenuItemRequest request);
}