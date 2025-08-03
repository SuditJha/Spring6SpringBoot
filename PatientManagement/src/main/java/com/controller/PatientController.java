package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exception.PatientNotFoundException;
import com.model.Patient;
import com.service.PatientService;

@RestController
public class PatientController {
	
	//include the appropriate annotation
	@Autowired
	private PatientService patientService;
	
	//include the appropriate annotation
	@GetMapping("/pms/find/{id}")
	public Patient findPatient(@PathVariable("id") Integer patientId) {
		
		//include the appropriate business logic	
		Patient p = patientService.searchPatient(patientId);
		if(p == null ) throw new PatientNotFoundException("No such patient id");
			return p;

	}
	
	

}
	 	  	    	    		        	 	
