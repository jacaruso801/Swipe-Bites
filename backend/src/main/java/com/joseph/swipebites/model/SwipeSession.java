package com.joseph.swipebites.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "swipe_sessions")
public class SwipeSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "session")
    private List<Swipe> swipes = new ArrayList<>();

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

    public List<Swipe> getSwipes() {
        return swipes;
    }

    public void setSwipes(List<Swipe> swipes) {
        this.swipes = swipes;
    }
}
