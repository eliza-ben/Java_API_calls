package com.example.uploadproxy.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handle(Exception e) {
    return ResponseEntity.badRequest().body(Map.of(
        "error", "REQUEST_FAILED",
        "message", e.getMessage()
    ));
  }
}
