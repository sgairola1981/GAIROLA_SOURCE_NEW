package com.circutbreaker.circut.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ServiceBController {

    @GetMapping("/data")
    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallback")
    public String getData() {
        // Simulating remote service call
        if (Math.random() > 0.5) {
            throw new RuntimeException("Remote service failure");
        }
        return "Data from Service B";
    }

    public String fallback(Throwable throwable) {
        return "Fallback response due to: " + throwable.getMessage();
    }
}