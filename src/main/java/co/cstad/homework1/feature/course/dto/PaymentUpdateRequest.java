package co.cstad.homework1.feature.course.dto;

import jakarta.validation.constraints.NotBlank;

public record PaymentUpdateRequest(
        @NotBlank(message = "Status is Require!!!")
        Boolean status
) {
}
