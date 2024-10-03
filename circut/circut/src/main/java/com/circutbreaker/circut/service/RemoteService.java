package com.circutbreaker.circut.service;

import org.springframework.stereotype.Service;

@Service
public class RemoteService {
    public String callRemoteService() {
        // Simulating remote service call
        if (Math.random() > 0.5) {
            throw new RuntimeException("Remote service failure");
        }
        return "Response from remote service";
    }
}