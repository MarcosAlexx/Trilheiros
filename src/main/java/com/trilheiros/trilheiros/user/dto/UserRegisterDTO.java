package com.trilheiros.trilheiros.user.dto;

public record UserRegisterDTO(
        String name,
        String email,
        String password,
        String whatsapp,
        Integer age,
        String city,
        String state
) {
}
