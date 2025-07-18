package com.cts.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.cts.patient.model.Patient;
import com.cts.patient.service.PatientService;

//fill the codepackage com.cts.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.cts.patient.model.Patient;
import com.cts.patient.service.PatientService;

@Configuration
@PropertySource("classpath:patient_details.properties")
public class AppConfig {

	// Enables @Value to work
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// Inner bean for Patient (no @Component)
	@Bean
	public Patient patient() {
		return new Patient();
	}

	@Bean
	public PatientService patientService() {
		PatientService service = new PatientService();
		service.setPatient(patient()); // inner bean
		return service;
	}
}

