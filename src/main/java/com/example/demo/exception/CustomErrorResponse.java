package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomErrorResponse {
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;

    public CustomErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
    }
}
