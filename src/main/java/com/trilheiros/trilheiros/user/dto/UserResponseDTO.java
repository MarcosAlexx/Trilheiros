package com.trilheiros.trilheiros.user.dto;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String whatsapp,
        Integer age,
        String city,
        String state,
        LocalDateTime createdAt
) {
}
