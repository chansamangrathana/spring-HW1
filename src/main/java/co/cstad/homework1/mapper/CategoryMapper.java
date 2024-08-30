package co.cstad.homework1.mapper;

import co.cstad.homework1.domain.Category;
import co.cstad.homework1.feature.category.dto.CategoryCreateRequest;
import co.cstad.homework1.feature.category.dto.CategoryResponse;
import co.cstad.homework1.feature.category.dto.CategoryUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Use for create category
    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);
    //Use for find category by id
    CategoryResponse toCategoryResponse(Category category);
    //Use for list all categories
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
    //Use for update category
    void fromCategoryUpdateRequest(CategoryUpdateRequest categoryUpdateRequest, @MappingTarget Category category);
}
