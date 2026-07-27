package com.joseph.swipebites.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}