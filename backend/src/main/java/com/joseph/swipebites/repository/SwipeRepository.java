package com.joseph.swipebites.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.Swipe;
import com.joseph.swipebites.model.SwipeDirection;

public interface SwipeRepository extends JpaRepository<Swipe, Long> {
    
    List<Swipe> findByDirection(SwipeDirection direction);
    
}