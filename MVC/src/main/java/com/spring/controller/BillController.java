package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Ticket;
import com.spring.service.BillService;

import jakarta.validation.Valid;

@Controller
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(value="/showpage", method=RequestMethod.GET)
	public String getShowPage(@ModelAttribute("ticket") Ticket ticket) {
		System.out.println("In Showpage");
		return "showpage";
	}
	
	@ModelAttribute("ticketList")
	public List<String> populateTicketType() {
		List<String> list = new ArrayList<>();
		list.add("Balcony");
		list.add("Floor");
		list.add("KingCircle");
		list.add("Queen Circle");
		
		return list;
		
	}
	
	@RequestMapping(value="/billDesk", method=RequestMethod.POST)
	public String calculateTotalCost(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			System.out.println("Error in billdesk --> Bill Controller");
			return "showpage";
		}
		else {
			double cost = billService.calculateTotalCost(ticket);
			model.addAttribute("cost", cost);
			return "billdesk";
		}
	}
	

}
