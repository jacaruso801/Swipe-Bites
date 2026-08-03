package com.joseph.swipebites.dto;

import java.time.LocalDateTime;

import com.joseph.swipebites.model.SessionStatus;

public class CurrentSessionResponse {

    private Long id;
    private SessionStatus status;
    private LocalDateTime createdAt;
    private long swipeCount;

    public CurrentSessionResponse(
            Long id,
            SessionStatus status,
            LocalDateTime createdAt,
            long swipeCount) {

        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.swipeCount = swipeCount;
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

    public long getSwipeCount() {
        return swipeCount;
    }
}