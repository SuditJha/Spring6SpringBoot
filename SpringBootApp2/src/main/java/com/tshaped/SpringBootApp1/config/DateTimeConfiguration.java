package com.tshaped.SpringBootApp1.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateTimeConfiguration {

	public DateTimeConfiguration() {
		// TODO Auto-generated constructor stub
		System.out.println("Date bean Created");
	}
	
	@Bean
	public LocalTime createTimeInstance() {
		LocalTime time = LocalTime.now();
		return time;
	}

}
