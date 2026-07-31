package com.joseph.swipebites.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "swipe_sessions")
public class SwipeSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    private LocalDateTime createdAt;

    protected SwipeSession() {
        // Required by JPA
    }

    public SwipeSession(User user) {
        this.user = user;
        this.status = SessionStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}