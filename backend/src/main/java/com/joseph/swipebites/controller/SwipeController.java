package com.joseph.swipebites.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joseph.swipebites.dto.SwipeRequest;
import com.joseph.swipebites.dto.SwipeResponse;
import com.joseph.swipebites.model.SwipeDirection;
import com.joseph.swipebites.service.SwipeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/swipes")
public class SwipeController {

    private final SwipeService swipeService;

    public SwipeController(SwipeService swipeService) {
        this.swipeService = swipeService;
    }

    @GetMapping
    public Page<SwipeResponse> getAllSwipes(
            @RequestParam(required = false) SwipeDirection direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String directionOrder) {

        return swipeService.getAllSwipes(
                direction,
                page,
                size,
                sortBy,
                directionOrder);
    }

    @PostMapping
    public SwipeResponse createSwipe(@Valid @RequestBody SwipeRequest request) {
        return swipeService.createSwipe(request);
    }
}
