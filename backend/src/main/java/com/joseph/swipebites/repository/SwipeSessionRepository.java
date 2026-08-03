package com.joseph.swipebites.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.SessionStatus;
import com.joseph.swipebites.model.SwipeSession;
import com.joseph.swipebites.model.User;

public interface SwipeSessionRepository
        extends JpaRepository<SwipeSession, Long> {

    Optional<SwipeSession> findByUserAndStatus(
            User user,
            SessionStatus status
    );

}