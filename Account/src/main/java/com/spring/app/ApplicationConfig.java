package com.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.app")
public class ApplicationConfig {

    @Bean
    public Account account() {
        Account acc = new Account("335647852", "Vanitha", 250000.0, loan()); // Injecting inner bean via constructor
        return acc;
    }

    // Inner bean
    @Bean
    public Loan loan() {
        return new Loan("HomeLoan", 150000.0);
    }
}
