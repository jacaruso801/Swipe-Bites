package com.joseph.swipebites.dto;

import java.time.Instant;
import java.util.Map;

public class ApiError {

    private Instant timestamp;
    private int status;
    private String message;
    private Map<String, String> errors;

    public ApiError(Instant timestamp, int status, String message, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}