package com.tshaped.SpringBootApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // => @ComponentScan
public class SpringBootApp1Application {

	public static void main(String[] args) {
	   ConfigurableApplicationContext container = SpringApplication.run(SpringBootApp1Application.class, args);
	   
	   
	  int count = container.getBeanDefinitionCount();
	  System.out.println("Beans Count in IOC " + count);
	}

}
