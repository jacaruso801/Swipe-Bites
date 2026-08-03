package com.joseph.swipebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseph.swipebites.model.SwipeSession;

public interface SwipeSessionRepository extends JpaRepository<SwipeSession, Long> {

}