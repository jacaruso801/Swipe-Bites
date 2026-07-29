package com.joseph.swipebites.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.joseph.swipebites.dto.SwipeRequest;
import com.joseph.swipebites.dto.SwipeResponse;
import com.joseph.swipebites.exception.RestaurantNotFoundException;
import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.model.Swipe;
import com.joseph.swipebites.model.SwipeDirection;
import com.joseph.swipebites.repository.RestaurantRepository;
import com.joseph.swipebites.repository.SwipeRepository;

@Service
public class SwipeService {

    private final SwipeRepository swipeRepository;
    private final RestaurantRepository restaurantRepository;

    public SwipeService(SwipeRepository swipeRepository, RestaurantRepository restaurantRepository) {
        this.swipeRepository = swipeRepository;
        this.restaurantRepository = restaurantRepository;
    }

    private SwipeResponse mapToResponse(Swipe swipe) {

        return new SwipeResponse(
                swipe.getId(),
                swipe.getRestaurant().getName(),
                swipe.getRestaurant().getCuisine(),
                swipe.getRestaurant().getPriceRange(),
                swipe.getDirection(),
                swipe.getCreatedAt()
        );
    }

    public Page<SwipeResponse> getAllSwipes(
            SwipeDirection direction,
            int page,
            int size,
            String sortBy,
            String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Swipe> swipes;

        if (direction != null) {
            swipes = swipeRepository.findByDirection(direction, pageable);
        } else {
            swipes = swipeRepository.findAll(pageable);
        }

        return swipes.map(this::mapToResponse);
    }

    public SwipeResponse createSwipe(SwipeRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException(request.getRestaurantId()));

        Swipe swipe = new Swipe(restaurant, request.getDirection());

        Swipe savedSwipe = swipeRepository.save(swipe);

        return mapToResponse(savedSwipe);
    }
}
