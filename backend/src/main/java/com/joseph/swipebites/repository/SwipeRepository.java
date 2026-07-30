package com.joseph.swipebites.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.Swipe;
import com.joseph.swipebites.model.SwipeDirection;
import com.joseph.swipebites.model.User;

public interface SwipeRepository extends JpaRepository<Swipe, Long> {

    Page<Swipe> findByDirection(SwipeDirection direction, Pageable pageable);

    Page<Swipe> findByUser(User user, Pageable pageable);

    Page<Swipe> findByUserAndDirection(
            User user,
            SwipeDirection direction,
            Pageable pageable
    );
}