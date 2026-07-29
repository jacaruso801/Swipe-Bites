package com.joseph.swipebites.dto;

import com.joseph.swipebites.model.SwipeDirection;

import jakarta.validation.constraints.NotNull;

public class SwipeRequest {

    @NotNull
    private Long restaurantId;

    @NotNull
    private SwipeDirection direction;

    public SwipeRequest() {
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public SwipeDirection getDirection() {
        return direction;
    }

    public void setDirection(SwipeDirection direction) {
        this.direction = direction;
    }
}