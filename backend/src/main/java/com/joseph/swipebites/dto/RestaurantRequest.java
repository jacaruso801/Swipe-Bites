package com.joseph.swipebites.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RestaurantRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Cuisine is required")
    @Size(max = 50, message = "Cuisine must be at most 50 characters")
    private String cuisine;

    @NotBlank(message = "Price range is required")
    @Pattern(
        regexp = "\\$|\\$\\$|\\$\\$\\$|\\$\\$\\$\\$",
        message = "Price range must be $, $$, $$$, or $$$$"
    )
    private String priceRange;

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}