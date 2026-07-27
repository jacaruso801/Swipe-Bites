package com.joseph.swipebites.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.repository.RestaurantRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;

    public DataLoader(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void run(String... args) {

        if (restaurantRepository.count() == 0) {

            restaurantRepository.save(new Restaurant(
                    "Mario's Pizza",
                    "Italian",
                    "$$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Sushi House",
                    "Japanese",
                    "$$$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Burger Barn",
                    "American",
                    "$"
            ));

            System.out.println("Loaded sample restaurants.");
        }
    }
}