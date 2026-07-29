package com.joseph.swipebites.dto;

import java.time.LocalDateTime;

import com.joseph.swipebites.model.SwipeDirection;

public class SwipeResponse {

    private Long id;
    private String restaurantName;
    private String cuisine;
    private String priceRange;
    private SwipeDirection direction;
    private LocalDateTime createdAt;

    public SwipeResponse(
            Long id,
            String restaurantName,
            String cuisine,
            String priceRange,
            SwipeDirection direction,
            LocalDateTime createdAt) {

        this.id = id;
        this.restaurantName = restaurantName;
        this.cuisine = cuisine;
        this.priceRange = priceRange;
        this.direction = direction;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public SwipeDirection getDirection() {
        return direction;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}