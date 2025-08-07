package com.service;

import org.springframework.stereotype.Service;
import com.model.Account;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//use appropriate annotation to configure AccountService as a Service
@Service
public class AccountService {

	// Return true if the password is valid 
	public boolean signup(Account account) {
        String password = account.getPassword();
        
        // Regex: At least one upper/lowercase, one digit, one special char, and 6+ chars
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{6,}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
