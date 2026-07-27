package com.joseph.swipebites.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseph.swipebites.model.Restaurant;

@Service
public class RestaurantService {

    public List<Restaurant> getRestaurants() {
        return List.of(
            new Restaurant(1L, "Mario's Pizza", "Italian", "$$"),
            new Restaurant(2L, "Sushi House", "Japanese", "$$$")
        );
    }
}