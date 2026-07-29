package com.joseph.swipebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.Swipe;

public interface SwipeRepository extends JpaRepository<Swipe, Long> {

}