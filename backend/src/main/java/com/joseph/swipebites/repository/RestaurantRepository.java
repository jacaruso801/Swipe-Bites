package com.joseph.swipebites.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joseph.swipebites.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("""
        SELECT r
        FROM Restaurant r
        WHERE r.id NOT IN (
            SELECT s.restaurant.id
            FROM Swipe s
        )
        """)
    List<Restaurant> findRestaurantsNotSwiped();

}