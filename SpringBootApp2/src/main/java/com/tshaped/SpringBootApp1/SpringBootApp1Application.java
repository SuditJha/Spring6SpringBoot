package com.tshaped.SpringBootApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tshaped.SpringBootApp1.service.Greeting;

@SpringBootApplication // => @ComponentScan
public class SpringBootApp1Application {

	public static void main(String[] args) {
	   ConfigurableApplicationContext container = SpringApplication.run(SpringBootApp1Application.class, args);
	   
//	   52 + 1 bean you created
	  int count = container.getBeanDefinitionCount();
	  System.out.println("Beans Count in IOC " + count);
	  
	  Greeting greet = container.getBean(Greeting.class);
	  System.out.println(greet.generateWish());
	}

}
