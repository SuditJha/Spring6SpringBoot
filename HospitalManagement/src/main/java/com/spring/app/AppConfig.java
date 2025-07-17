package com.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Use appropriate annotation 
@Configuration
@ComponentScan(basePackages="com.spring.app")
public class AppConfig {
    
    //Use appropriate annotation 
	@Bean
    public Document newYorkDocument() {
        
        Document document = new Document();
        document.setName("Alice");
        document.setIdProof("Insurance");
        document.setCondition("Flu");
        
        return document;
    }
    
    //Use appropriate annotation 
	@Bean
    public Document losAngelesDocument() {
        
        Document document = new Document();
        document.setName("Bob");
        document.setIdProof("ID Card");
        document.setCondition("Sprain");
        
        return document;
    }
}
