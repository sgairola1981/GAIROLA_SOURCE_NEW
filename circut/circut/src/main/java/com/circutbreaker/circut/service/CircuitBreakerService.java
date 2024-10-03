package com.circutbreaker.circut.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {

    private final RemoteService remoteService;

    @Autowired
    public CircuitBreakerService(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
    public String callRemoteService() {
        return remoteService.callRemoteService();
    }

    public String fallback(Throwable throwable) {
        return "Fallback response due to: " + throwable.getMessage();
    }
}