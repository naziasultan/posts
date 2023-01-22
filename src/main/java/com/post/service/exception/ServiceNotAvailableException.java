package com.post.service.exception;

public class ServiceNotAvailableException extends RuntimeException {
    public ServiceNotAvailableException(String message) {
        super(message);
    }
}