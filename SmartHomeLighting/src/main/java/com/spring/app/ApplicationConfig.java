package com.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Use appropriate annotations
@Configuration
@ComponentScan(basePackages="com.spring.app")
public class ApplicationConfig {
    
	//Use appropriate annotation 
	@Bean
	public SmartHome ledHome(LEDLighting lightingSystem) {
	    // FILL THE CODE HERE
	    return new SmartHome("Eco Friendly House", lightingSystem);
	}

	//Use appropriate annotation 
	@Bean
	public SmartHome incandescentHome(IncandescentLighting lightingSystem) {
	   // FILL THE CODE HERE
	   return new SmartHome("Classic Beauty Home", lightingSystem);
	}

}
