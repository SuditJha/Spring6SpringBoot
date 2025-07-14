package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static Account loadAccount() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        return context.getBean(Account.class);
    }

    public static void main(String[] args) {
        Account account = loadAccount();

        // Display Account and Loan details
        System.out.println("Account number:" + account.getAccNumber());
        System.out.println("Account holder name:" + account.getAccHolderName());
        System.out.println("Balance:" + account.getAccBalance());

        Loan loan = account.getLoanInfo();
        System.out.println("Loan type:" + loan.getLoanType());
        System.out.println("Loan amount:" + loan.getLoanAmount());
    }
}
