package com.trilheiros.trilheiros.trail.exception;

public class TrailReviewNotFoundException extends RuntimeException {
    public TrailReviewNotFoundException(Long id) {
        super("Trail review with ID " + id + " not found");
    }
}
