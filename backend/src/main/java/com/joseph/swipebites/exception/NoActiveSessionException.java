package com.joseph.swipebites.exception;

public class NoActiveSessionException extends RuntimeException {

    public NoActiveSessionException() {
        super("User does not have an active swipe session.");
    }
}