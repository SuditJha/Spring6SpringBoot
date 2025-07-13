package com.tshaped.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {

	public LaunchApp() {
		// TODO Auto-generated constructor stub
	}
	 
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationConfig.xml");
		
	}

}
