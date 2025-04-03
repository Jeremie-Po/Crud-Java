package com.immo.demo.services;

import org.springframework.http.HttpStatus;

public class ConfirmationMessage {
    private final String message;
    private final HttpStatus status;

    public ConfirmationMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public Integer getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }
}
