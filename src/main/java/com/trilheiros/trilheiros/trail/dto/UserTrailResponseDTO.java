package com.trilheiros.trilheiros.trail.dto;

import java.time.LocalDateTime;

public record UserTrailResponseDTO(
        Long id, Long userId, Long trailId, boolean saved, boolean completed, LocalDateTime completedAt, boolean reminder)
{
}