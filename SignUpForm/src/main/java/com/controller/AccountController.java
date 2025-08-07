package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.model.Account;
import com.service.AccountService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//use appropriate annotation to configure AccountController as Controller
@Controller
public class AccountController {

//	Use appropriate annotation
	@Autowired
	private AccountService service;



	@RequestMapping(value="/showPage")
	public String showPage(@ModelAttribute("account") Account account) {
		
		return "showPage";
	}
	
	
	// invoke the service class - signup method.
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signup(@ModelAttribute("account") Account account, ModelMap model) {

		// fill the code
		boolean isValid = service.signup(account);
		
		 if (isValid) {
	            model.addAttribute("message", "Your Account is Created");
	        } else {
	            model.addAttribute("message", "Invalid Password");
	        }
		return "showPage";
	}

}
	 	  	      	 	    	      	    	      	 	
