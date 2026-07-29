package com.joseph.swipebites.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseph.swipebites.model.Swipe;
import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.dto.SwipeRequest;
import com.joseph.swipebites.dto.SwipeResponse;
import com.joseph.swipebites.exception.RestaurantNotFoundException;
import com.joseph.swipebites.repository.RestaurantRepository;
import com.joseph.swipebites.repository.SwipeRepository;

import java.util.stream.Collectors;

@Service
public class SwipeService {

    private final SwipeRepository swipeRepository;
    private final RestaurantRepository restaurantRepository;

    public SwipeService(SwipeRepository swipeRepository, RestaurantRepository restaurantRepository) {
        this.swipeRepository = swipeRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<SwipeResponse> getAllSwipes() {

    return swipeRepository.findAll()
            .stream()
            .map(swipe -> new SwipeResponse(
                    swipe.getId(),
                    swipe.getRestaurant().getName(),
                    swipe.getRestaurant().getCuisine(),
                    swipe.getRestaurant().getPriceRange(),
                    swipe.getDirection(),
                    swipe.getCreatedAt()
            ))
            .collect(Collectors.toList());
    }

    public Swipe createSwipe(SwipeRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException(request.getRestaurantId()));

        Swipe swipe = new Swipe(restaurant, request.getDirection());

        return swipeRepository.save(swipe);
    }
}