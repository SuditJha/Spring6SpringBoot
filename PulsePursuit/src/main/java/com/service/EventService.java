package com.service;

import org.springframework.stereotype.Service;
import com.model.Registration;

@Service
public class EventService {

    public double calculateRegistrationCost(Registration registration) {
        double cost = switch (registration.getEventType()) {
            case "GolfTournament" -> 2000;
            case "Triathlon" -> 1000;
            case "Marathon" -> 1200;
            case "HikingChallenge" -> 1500;
            default -> 0;
        };
        return cost + (cost * 0.18); // 18% tax
    }
}
