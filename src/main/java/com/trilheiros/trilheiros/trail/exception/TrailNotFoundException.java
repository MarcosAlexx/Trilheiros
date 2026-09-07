package com.trilheiros.trilheiros.trail.exception;


public class TrailNotFoundException extends  RuntimeException {

    public TrailNotFoundException(String name) {
        super("Trail not found: " + name);
    }
}
