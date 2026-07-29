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
                    "El Rincon",
                    "Mexican",
                    "$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Shogun",
                    "Japanese",
                    "$$$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Whiskey Biscuits",
                    "American",
                    "$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Kaz's BBQ",
                    "BBQ",
                    "$$"
            ));

            restaurantRepository.save(new Restaurant(
                    "Chick-fil-a",
                    "American",
                    "$"
            ));

            System.out.println("Loaded sample restaurants.");
        }
    }
}