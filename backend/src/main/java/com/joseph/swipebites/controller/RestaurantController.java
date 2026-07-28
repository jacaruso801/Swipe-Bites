package com.joseph.swipebites.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.dto.RestaurantRequest;
import com.joseph.swipebites.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(
            @Valid @RequestBody RestaurantRequest request) {

        Restaurant restaurant = restaurantService.createRestaurant(request);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
}