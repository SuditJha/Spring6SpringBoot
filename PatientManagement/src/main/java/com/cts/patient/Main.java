package com.cts.patient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.patient.config.AppConfig;
import com.cts.patient.service.PatientService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PatientService service = context.getBean(PatientService.class);
		service.getPatientDetails();
	}
}
