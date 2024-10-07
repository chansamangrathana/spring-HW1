package co.cstad.homework1.feature.category;


import co.cstad.homework1.feature.category.dto.CategoryCreateRequest;
import co.cstad.homework1.feature.category.dto.CategoryResponse;
import co.cstad.homework1.feature.category.dto.CategoryUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;


    //Create a new category
    @PreAuthorize("hasAuthority('SCOPE_openid')")
//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        categoryService.createCategory(categoryCreateRequest);
    }

    //Find all categories
    @GetMapping
    List<CategoryResponse> findAllCategory() {
        return categoryService.findAllCategory();
    }

    //Find category by id
    @GetMapping("/{id}")
    CategoryResponse findCategoryById(@Valid @PathVariable String id) {

        return categoryService.findCategoryById(id);
    }


    //Update category by id
    @PutMapping("/{id}")
    CategoryResponse updateCategory(@Valid @PathVariable String id, @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        return categoryService.updateCategory(id, categoryUpdateRequest);
    }

    //Delete category by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCategory(@Valid @PathVariable String id) {
        categoryService.deleteCategory(id);
    }

    //Enable category by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/enable")
    void enableCategory(@Valid @PathVariable("id") String id) {
        categoryService.enableCategory(id);
    }
    //Disable category by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/disable")
    void disableCategory(@Valid @PathVariable("id") String id) {
        categoryService.disableCategory(id);
    }

}
