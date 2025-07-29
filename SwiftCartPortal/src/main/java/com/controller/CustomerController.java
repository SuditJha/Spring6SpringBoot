package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Customer;
import com.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping("/index")
    public String registrationPage(@ModelAttribute("customer") Customer customer) {
        return "index";
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String validateInfo(@ModelAttribute("customer") Customer customer) {
        int result = service.validateInfo(customer);
        if (result == 1)
            return "success";
        else if (result == -2)
            return "invalidEmail";
        else
            return "invalidMobileNumber";
    }
}
