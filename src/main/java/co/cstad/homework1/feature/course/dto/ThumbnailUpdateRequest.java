package co.cstad.homework1.feature.course.dto;

import jakarta.validation.constraints.NotBlank;

public record ThumbnailUpdateRequest(
        @NotBlank(message = "Thumbnail is required!!!")
        String thumbnail
) {
}
