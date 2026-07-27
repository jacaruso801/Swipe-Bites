package com.joseph.swipebites.model;

public class Restaurant {

    private Long id;
    private String name;
    private String cuisine;
    private String priceRange;

    public Restaurant(Long id, String name, String cuisine, String priceRange) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.priceRange = priceRange;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getPriceRange() {
        return priceRange;
    }
}