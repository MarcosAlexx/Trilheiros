package com.trilheiros.trilheiros.trail.dto;

import com.trilheiros.trilheiros.trail.entity.Difficulty;

public record TrailResponseDTO(
        Long id, String name, String description, String city, String state, Difficulty difficulty, double distanceKm, double durationHours, double longitude, double latitude, String contact
) {
}
