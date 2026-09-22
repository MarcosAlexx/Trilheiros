package com.trilheiros.trilheiros.user.exception;

import com.trilheiros.trilheiros.trail.exception.TrailNotFoundException;
import com.trilheiros.trilheiros.trail.exception.TrailReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TrailNotFoundException.class)
    public ResponseEntity<String> handleTrailNotFound(TrailNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TrailReviewNotFoundException.class)
    public ResponseEntity<String> handleTrailReviewNotFound(TrailReviewNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}