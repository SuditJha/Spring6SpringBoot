package com.spring.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SmartLoan loan = (SmartLoan) context.getBean("smartLoan");

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Loan Processing System");
        System.out.println("Customer Name: " + loan.getCustomerName());
        System.out.println("Customer ID: " + loan.getCustomerId());

        System.out.println("Enter loan amount");
        double amount = sc.nextDouble();

        System.out.println("Enter loan tenure in months");
        int months = sc.nextInt();

        sc.nextLine(); // consume newline
        System.out.println("Enter loan type");
        String loanType = sc.nextLine();

        double emi = loan.calculateEMI(amount, months, loanType);
        if (emi == -1) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Your EMI for " + months + " months will be $" + emi);
        }

        sc.close();
    }
}
