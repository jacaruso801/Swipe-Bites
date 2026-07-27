package com.joseph.swipebites.dto;

public class RestaurantRequest {

    private String name;
    private String cuisine;
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