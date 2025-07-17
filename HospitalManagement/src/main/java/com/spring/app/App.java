package com.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
       
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeadHospital hospital = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select location:\n1.New York\n2.Los Angeles");
        int choice = scanner.nextInt();
        
        if(choice == 1){
           // FILL THE CODE HERE
        	hospital = context.getBean(NewYorkHospital.class);
        	
        } else if(choice == 2){
            // FILL THE CODE HERE
        	hospital = context.getBean(LosAngelesHospital.class);
        } else {
            System.out.println("Wrong Choice");
            return;
        }
        hospital.doDocumentVerification();
        hospital.provideTreatment();
    }
}
