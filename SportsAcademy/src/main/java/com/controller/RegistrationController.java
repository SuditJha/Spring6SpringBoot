package com.controller;

import java.util.Arrays;
import java.util.List;

import com.model.Registration;
import com.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @RequestMapping(value="/showPage")
    public String showPage(@ModelAttribute("registration") Registration registration) {
        return "showPage";
    }

    @ModelAttribute("sportsList")
    public List<String> populateSports() {
        return Arrays.asList("Cricket", "Football", "Hockey", "Badminton", "Tennis");
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String sportsRegistration(@ModelAttribute("registration") Registration registration, ModelMap model) {
        int fees = service.sportsRegistration(registration);
        String message = "Thanks for visiting. Your monthly fees for " + registration.getOptedSports() + " training is $" + fees;
        model.addAttribute("message", message);
        return "showPage";
    }
}
