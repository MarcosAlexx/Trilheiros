package com.trilheiros.trilheiros.trail.dto;

import java.time.LocalDateTime;

public record TrailReviewResponseDTO(
    Long id,
    Long trailId,
    Long userId,
    int rating,
    String comment,
    LocalDateTime createdAt
) {
}
