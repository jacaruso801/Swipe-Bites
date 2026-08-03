package com.joseph.swipebites.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "swipes")
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SwipeDirection direction;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private SwipeSession session;

    protected Swipe() {
        // Required by JPA
    }

    public Swipe(User user,
            SwipeSession session,
            Restaurant restaurant,
            SwipeDirection direction) {

        this.user = user;
        this.session = session;
        this.restaurant = restaurant;
        this.direction = direction;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public SwipeDirection getDirection() {
        return direction;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setDirection(SwipeDirection direction) {
        this.direction = direction;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SwipeSession getSession() {
        return session;
    }

    public void setSession(SwipeSession session) {
        this.session = session;
    }
}
