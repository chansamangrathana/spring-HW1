package co.cstad.homework1.feature.exception;

import lombok.Builder;

@Builder
public record FieldError(
        String field,
        String detail
) {
}
