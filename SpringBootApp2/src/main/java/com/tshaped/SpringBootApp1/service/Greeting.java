package com.tshaped.SpringBootApp1.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class Greeting {
	
	@Autowired
	private LocalTime time;
	
	public Greeting() {
		// TODO Auto-generated constructor stub
		System.out.println("Greetings Bean Created --> Constructor");
	}
	

	public String generateWish() {
		
		int hour = time.getHour();
		
		return hour < 12 ? "Good Morning" : "Good Evening" ;
	}
	
	

}
