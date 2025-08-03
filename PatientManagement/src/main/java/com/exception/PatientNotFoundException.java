package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//include the appropriate annotation to change the status
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class PatientNotFoundException extends RuntimeException{

		public PatientNotFoundException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
	
		//include a one argument constructor of type String and write the code to pass the message to the super class

}
