package com.thinh.Standee.config;

import com.thinh.Standee.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<?>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        Throwable cause = e.getCause();
        String[] parts = cause.getMessage().split("'");
        String fieldValue = parts[1];
        if (cause.getMessage().contains("UKob8kqyqqgmefl0aco34akdtpe")) {
            return ResponseEntity.status(409).body(
                    ApiResponse.builder()
                            .success(false)
                            .message("Duplicate entry")
                            .error(
                                    ApiResponse.ErrorDetails.builder()
                                            .code("DUPLICATE_EMAIL")
                                            .message("Duplicate entry for email: " + fieldValue)
                                            .details("The email " + fieldValue + " already exists in the database.")
                                            .build()
                            )
                            .timestamp(LocalDateTime.now())
                            .build()
            );
        } else {
            return ResponseEntity.status(409).body(
                    ApiResponse.builder()
                            .success(false)
                            .message("Duplicate entry")
                            .error(
                                    ApiResponse.ErrorDetails.builder()
                                            .code("DUPLICATE_PHONE")
                                            .message("Duplicate entry for phone: " + fieldValue)
                                            .details("The phone " + fieldValue + " already exists in the database.")
                                            .build()
                            )
                            .timestamp(LocalDateTime.now())
                            .build()
            );
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .success(false)
                        .message("Validation error")
                        .error(
                                ApiResponse.ErrorDetails.builder()
                                        .code("VALIDATION_ERROR")
                                        .message(e.getBindingResult().getFieldError().getDefaultMessage())
                                        .details("Invalid value for field: " + e.getBindingResult().getFieldError().getField())
                                        .build()
                        )
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
