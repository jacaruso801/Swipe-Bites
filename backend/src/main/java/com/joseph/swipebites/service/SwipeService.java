package com.joseph.swipebites.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.joseph.swipebites.dto.SwipeRequest;
import com.joseph.swipebites.dto.SwipeResponse;
import com.joseph.swipebites.exception.RestaurantNotFoundException;
import com.joseph.swipebites.model.Restaurant;
import com.joseph.swipebites.model.Swipe;
import com.joseph.swipebites.model.SwipeDirection;
import com.joseph.swipebites.model.User;
import com.joseph.swipebites.repository.RestaurantRepository;
import com.joseph.swipebites.repository.SwipeRepository;

@Service
public class SwipeService {

    private final SwipeRepository swipeRepository;
    private final RestaurantRepository restaurantRepository;

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of(
            "createdAt",
            "direction"
    );

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

    private User getCurrentUser() {

        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();

        return (User) authentication.getPrincipal();
    }

    public Page<SwipeResponse> getAllSwipes(
            SwipeDirection direction,
            int page,
            int size,
            String sortBy,
            String sortDirection) {

        if (!ALLOWED_SORT_FIELDS.contains(sortBy)) {
            throw new IllegalArgumentException("Invalid sort field: " + sortBy);
        }

        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        User currentUser = getCurrentUser();

        Page<Swipe> swipes;

        if (direction != null) {
            swipes = swipeRepository.findByUserAndDirection(
                    currentUser,
                    direction,
                    pageable
            );
        } else {
            swipes = swipeRepository.findByUser(
                    currentUser,
                    pageable
            );
        }

        return swipes.map(this::mapToResponse);
    }

    public SwipeResponse createSwipe(SwipeRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException(request.getRestaurantId()));

        User currentUser = getCurrentUser();

        Swipe swipe = new Swipe(
                currentUser,
                restaurant,
                request.getDirection()
        );

        Swipe savedSwipe = swipeRepository.save(swipe);

        return mapToResponse(savedSwipe);
    }
}
