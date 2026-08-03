package com.joseph.swipebites.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseph.swipebites.dto.CurrentSessionResponse;
import com.joseph.swipebites.dto.SwipeSessionResponse;
import com.joseph.swipebites.service.SwipeSessionService;

@RestController
@RequestMapping("/api/sessions")
public class SwipeSessionController {

    private final SwipeSessionService swipeSessionService;

    public SwipeSessionController(SwipeSessionService swipeSessionService) {
        this.swipeSessionService = swipeSessionService;
    }

    @GetMapping("/current")
    public CurrentSessionResponse getCurrentSession() {
        return swipeSessionService.getCurrentSession();
    }

    @PostMapping
    public SwipeSessionResponse createSession() {
        return swipeSessionService.createSession();
    }
}
