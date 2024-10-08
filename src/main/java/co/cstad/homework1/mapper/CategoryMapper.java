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
    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);
    CategoryResponse toCategoryResponse(Category category);
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
    void fromCategoryUpdateRequest(CategoryUpdateRequest categoryUpdateRequest, @MappingTarget Category category);
}
