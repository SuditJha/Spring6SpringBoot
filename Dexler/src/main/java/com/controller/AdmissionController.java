package com.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Admission;
import com.service.AdmissionService;
import com.validate.CustomValidator;

import jakarta.validation.Valid;


// use appropriate annotation
@Controller
public class AdmissionController {
	
    // use appropriate annotation
	@Autowired
    private CustomValidator custValidator;
	
    // use appropriate annotation
	@Autowired
    private AdmissionService admissionService;
	
	@RequestMapping(value="/showPage", method=RequestMethod.GET)
	public String showPage(@ModelAttribute("admission") Admission admission) {
	    return "showPage";
	}

	@ModelAttribute("programNames")
	public ArrayList<String> populateAvailablePrograms() {
	    ArrayList<String> programs = new ArrayList<>();
	    programs.add("Play Group");
	    programs.add("Nursery");
	    programs.add("Euro Junior");
	    programs.add("Euro Senior");
	    return programs;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPreschooler(@Valid @ModelAttribute("admission") Admission admission,
	                                  BindingResult result,
	                                  ModelMap model) {
	    custValidator.validate(admission, result);

	    if (result.hasErrors()) {
	        return "showPage";
	    }

	    double fee = admissionService.calculateProgramFee(admission);
	    model.addAttribute("message", 
	        "Preschool registration successful for " + admission.getChildName() + 
	        ", Program Fees: " + fee);
	    return "success";
	}


	
}
