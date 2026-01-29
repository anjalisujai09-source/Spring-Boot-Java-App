package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {

    private String message;
    private LocalDateTime timestamp;

    public ApiError(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

}
