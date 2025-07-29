package com.service;

import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public class CustomerService {

    public int validateInfo(Customer customer) {
        String email = customer.getEmailId();
        long mobile = customer.getMobileNumber();

        // Basic email regex
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        boolean emailValid = email.matches(emailRegex);

        // Mobile number must be 10 digits starting from 6-9
        String mobileStr = String.valueOf(mobile);
        boolean mobileValid = mobileStr.matches("[6-9][0-9]{9}");

        if (!emailValid)
            return -2;
        else if (!mobileValid)
            return -1;
        else
            return 1;
    }
}
