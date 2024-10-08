package co.cstad.homework1.feature.category;


import co.cstad.homework1.feature.category.dto.CategoryCreateRequest;
import co.cstad.homework1.feature.category.dto.CategoryResponse;
import co.cstad.homework1.feature.category.dto.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    //Create category
    void createCategory(CategoryCreateRequest categoryCreateRequest);

    //Find all
    List<CategoryResponse> findAllCategory();

    //Find
    CategoryResponse findCategoryById(String id);

    //Update
    CategoryResponse updateCategory(String id, CategoryUpdateRequest categoryUpdateRequest);

    //Delete
    void deleteCategory(String id);

    //Enable
    void enableCategory(String id);

    //Disable
    void disableCategory(String id);

}
