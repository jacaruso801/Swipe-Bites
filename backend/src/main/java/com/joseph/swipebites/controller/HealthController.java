package com.joseph.swipebites.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public HealthResponse health() {
        return new HealthResponse(
                "UP",
                "SwipeBites API",
                "0.1.0");
    }

    public record HealthResponse(
            String status,
            String application,
            String version) {
    }
}