package com.joseph.swipebites.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cuisine;

    private String priceRange;

    protected Restaurant() {
        // Required by JPA
    }

    public Restaurant(String name, String cuisine, String priceRange) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}