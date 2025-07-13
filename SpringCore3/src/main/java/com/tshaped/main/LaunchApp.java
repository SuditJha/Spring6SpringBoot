package com.tshaped.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tshaped.config.Config;
import com.tshaped.service.Password;

public class LaunchApp {

	public LaunchApp() {
		// TODO Auto-generated constructor stub
	}
	 
	public static void main(String[] args) {
		
		ApplicationContext container = new AnnotationConfigApplicationContext(Config.class) ;
		
		Password pass = container.getBean(Password.class);
		pass.aboutAlgo();
		
	}

}