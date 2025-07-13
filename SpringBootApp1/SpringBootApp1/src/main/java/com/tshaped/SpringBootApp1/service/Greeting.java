package com.tshaped.SpringBootApp1.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class Greeting {
	
	static {
		System.out.println("Static Block");
	}
	
	{
		System.out.println("Non static Java initialization block");
	}

	public Greeting() {
		// TODO Auto-generated constructor stub
		System.out.println("Greetings Bean Created --> Constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Greeting Bean Init Method");
	}
	
	public String generateWish() {
		return "Good Morning";
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Greeting Bean Destroyed");
	}

}
