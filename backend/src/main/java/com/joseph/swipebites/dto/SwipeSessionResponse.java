package com.joseph.swipebites.dto;

import java.time.LocalDateTime;

import com.joseph.swipebites.model.SessionStatus;

public class SwipeSessionResponse {

    private Long id;
    private SessionStatus status;
    private LocalDateTime createdAt;

    public SwipeSessionResponse(
            Long id,
            SessionStatus status,
            LocalDateTime createdAt) {

        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}