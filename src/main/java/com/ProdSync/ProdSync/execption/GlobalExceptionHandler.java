package com.ProdSync.ProdSync.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<Map<String, Object>> handleRest(RestException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", ex.getStatus());
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.badRequest().body(body);
    }
}
