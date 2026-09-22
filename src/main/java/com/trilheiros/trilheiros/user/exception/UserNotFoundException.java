package com.trilheiros.trilheiros.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("User not found: " + email);
    }

    public UserNotFoundException(Long id) {
        super("User not found: " + id);
    }
}
