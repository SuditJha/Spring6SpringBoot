package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bean.ATMCard;
import com.dao.ATMCardDAO;

@RestController
public class ATMController {
    
    @Autowired
    private ATMCardDAO atmCardDAO;
    
    @PostMapping("/issueATMCardToAccount/{accountNumber}")
    public void issueATMCardToAccount(@PathVariable int accountNumber, @RequestBody ATMCard atmCardObject) {
        atmCardDAO.issueATMCardToAccount(accountNumber, atmCardObject);
    }
}