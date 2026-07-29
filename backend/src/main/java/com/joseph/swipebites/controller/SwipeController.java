package com.joseph.swipebites.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseph.swipebites.dto.SwipeRequest;
import com.joseph.swipebites.dto.SwipeResponse;
import com.joseph.swipebites.model.Swipe;
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
    public List<SwipeResponse> getAllSwipes() {
        return swipeService.getAllSwipes();
    }

    @PostMapping
public Swipe createSwipe(@Valid @RequestBody SwipeRequest request) {
    return swipeService.createSwipe(request);
}
}