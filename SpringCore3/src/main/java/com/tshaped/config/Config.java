package com.tshaped.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tshaped.service.Password;

@Configuration
@ComponentScan(basePackages={"com.tshaped"})
public class Config // id=config 
{

	public Config() {
		// TODO Auto-generated constructor stub
		System.out.println("Config Bean Created");
	}
	
	@Bean
	public Password createPass() {
		return new Password("SHA");
	}

}
