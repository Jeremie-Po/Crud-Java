package com.immo.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    // Classe pour encapsuler le message d'erreur dans un objet JSON
    private final String message;
    private final HttpStatus status;

    public ErrorMessage(String message, HttpStatus status) {
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
