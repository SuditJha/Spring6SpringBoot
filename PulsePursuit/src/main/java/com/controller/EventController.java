package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.model.Registration;
import com.service.EventService;

import jakarta.validation.Valid;

@Controller
public class EventController {

    @Autowired
    private EventService service;

    @ModelAttribute("eventTypeList")
    public List<String> populateEventType() {
        return Arrays.asList("GolfTournament", "Triathlon", "Marathon", "HikingChallenge");
    }

    @GetMapping("/showPage")
    public String showPage(@ModelAttribute("registration") Registration registration) {
        return "showPage";
    }

    @PostMapping("/register")
    public String registerEvent(@ModelAttribute("registration") @Valid Registration registration,
                                 BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "showPage";
        }
        double totalCost = service.calculateRegistrationCost(registration);
        model.put("message", "Dear " + registration.getParticipantName() + ", You have to pay Rs." + totalCost);
        return "showPage";
    }
}
