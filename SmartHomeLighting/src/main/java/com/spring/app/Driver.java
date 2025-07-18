package com.spring.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Scanner scanner = new Scanner(System.in);
        SmartHome smartHome = null;
        System.out.println("Select option\n 1.LED Lighting \n 2.Incandescent Lighting");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            // Fill the code here
        	smartHome = context.getBean("ledHome",SmartHome.class);
        	
        } else if (choice == 2) {
            // Fill the code here
        	smartHome = context.getBean("incandescentHome",SmartHome.class);
        } else {
            System.out.println("Wrong choice");
            scanner.close();
            return;
        }
        smartHome.getReport();
        scanner.close();
    }
}
