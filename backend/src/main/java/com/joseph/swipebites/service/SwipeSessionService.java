package com.joseph.swipebites.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.joseph.swipebites.dto.SwipeSessionResponse;
import com.joseph.swipebites.model.SwipeSession;
import com.joseph.swipebites.model.User;
import com.joseph.swipebites.repository.SwipeSessionRepository;

@Service
public class SwipeSessionService {

    private final SwipeSessionRepository swipeSessionRepository;

    public SwipeSessionService(SwipeSessionRepository swipeSessionRepository) {
        this.swipeSessionRepository = swipeSessionRepository;
    }

    public SwipeSessionResponse createSession() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        SwipeSession session = new SwipeSession(currentUser);

        SwipeSession savedSession = swipeSessionRepository.save(session);

        return new SwipeSessionResponse(
                savedSession.getId(),
                savedSession.getStatus(),
                savedSession.getCreatedAt()
        );
    }
}