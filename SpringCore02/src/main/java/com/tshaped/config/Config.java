package com.tshaped.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tshaped.service.Password;

@Configuration
public class Config {

	public Config() {
		// TODO Auto-generated constructor stub
		System.out.println("Config Bean Created");
	}
	
	@Bean
	public Password createPass() {
		return new Password("SHA");
	}

}
