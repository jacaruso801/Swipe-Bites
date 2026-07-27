package com.joseph.swipebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}