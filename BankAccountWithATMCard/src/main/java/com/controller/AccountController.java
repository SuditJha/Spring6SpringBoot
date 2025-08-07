package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bean.Account;
import com.bean.CurrentAccount;
import com.bean.SavingsAccount;
import com.dao.AccountDAO;

@RestController
public class AccountController {
    
    @Autowired
    private AccountDAO accountDao;
    
    @PostMapping("/openAccount/CURR")
    public void openAccount(@RequestBody CurrentAccount account) {
        accountDao.openAccount(account);
    }
    
    @PostMapping("/openAccount/SAV")
    public void openAccount(@RequestBody SavingsAccount account) {
        accountDao.openAccount(account);
    }
    
    @GetMapping("/retrieveAccountBasedOnCardType/{cardType}")
    public List<Account> retrieveAccountBasedOnCardType(@PathVariable String cardType) {
        return accountDao.retrieveAccountBasedOnCardType(cardType);
    }
}