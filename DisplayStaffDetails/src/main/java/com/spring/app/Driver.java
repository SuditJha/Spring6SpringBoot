package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    
    public static Department loadStaffDetails() {

        ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Department dept = container.getBean(Department.class);
        return dept;
    }

    public static void main(String[] args) {
        // FILL THE CODE HERE
    	Department dept = loadStaffDetails();
    	dept.displayStaffDetails();
    	}
}
