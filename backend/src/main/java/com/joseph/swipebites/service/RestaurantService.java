package com.joseph.swipebites.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.joseph.swipebites.dto.RestaurantRequest;
import com.joseph.swipebites.exception.RestaurantNotFoundException;
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

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    public Restaurant getNextRestaurant() {

        List<Restaurant> restaurants = restaurantRepository.findRestaurantsNotSwiped();

        if (restaurants.isEmpty()) {
            throw new RuntimeException("No restaurants available");
        }

        return restaurants.get(
                new Random().nextInt(restaurants.size())
        );
    }

    public Restaurant createRestaurant(RestaurantRequest request) {

        Restaurant restaurant = new Restaurant(
                request.getName(),
                request.getCuisine(),
                request.getPriceRange()
        );

        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, RestaurantRequest request) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        restaurant.setName(request.getName());
        restaurant.setCuisine(request.getCuisine());
        restaurant.setPriceRange(request.getPriceRange());

        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()
                        -> new RestaurantNotFoundException(id));

        restaurantRepository.delete(restaurant);
    }
}
