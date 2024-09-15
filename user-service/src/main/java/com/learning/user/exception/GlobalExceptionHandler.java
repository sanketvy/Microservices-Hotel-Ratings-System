package com.learning.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleGlobalRuntimeExceptions(RuntimeException runtimeException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(runtimeException.getMessage());
    }
}
