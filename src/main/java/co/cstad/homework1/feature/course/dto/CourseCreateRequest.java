package co.cstad.homework1.feature.course.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CourseCreateRequest(
        String title,
        String slug,
        String description,
        String  thumbnail,
        BigDecimal price,
        String contents,
        @NotBlank(message = "CategoryName is required!!!")
        String categoryName
) {
}
