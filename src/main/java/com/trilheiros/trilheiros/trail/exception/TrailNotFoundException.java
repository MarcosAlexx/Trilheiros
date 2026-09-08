package com.trilheiros.trilheiros.trail.exception;


public class TrailNotFoundException extends  RuntimeException {

    public TrailNotFoundException(Long id) {
        super("Trail not found: " + id);
    }
}
