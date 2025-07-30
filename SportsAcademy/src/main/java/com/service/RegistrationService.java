package com.service;

import com.model.Registration;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public int sportsRegistration(Registration registration) {
        switch (registration.getOptedSports()) {
            case "Cricket":
                return 500;
            case "Football":
                return 350;
            case "Hockey":
                return 750;
            case "Badminton":
                return 400;
            case "Tennis":
                return 450;
            default:
                return 0;
        }
    }
}
