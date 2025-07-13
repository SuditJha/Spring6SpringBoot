package com.spring.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Use appropriate annotations
@Configuration
@ComponentScan(basePackages= {"com.spring"})
public class ApplicationConfig {

    //Use appropriate annotation
	@Bean
    public Staff staff() {
         // FILL THE CODE HERE
	    return new Staff(1,"Ragul", "CSE", 9445543300L);
    }

    //Use appropriate annotation 
    @Bean
    public Department department() {
         // FILL THE CODE HERE
    	List<Staff> staff = new ArrayList<>();
    	staff.add(staff());
	    return new Department(123, staff);
    }
}
