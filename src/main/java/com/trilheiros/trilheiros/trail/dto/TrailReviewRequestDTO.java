package com.trilheiros.trilheiros.trail.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TrailReviewRequestDTO(
        @NotNull(message = "Trail ID is required")
        Long trailId,

        @NotNull(message = "User ID is required")
        Long userId,

        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        int rating,

        String comment
) {
}
