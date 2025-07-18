package com.spring.app;

import java.util.List;

public abstract class Loan {

    private int customerId;
    private String customerName;

    public Loan() {

    }

    public Loan(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
        
    public abstract double calculateEMI(double loanAmount, int tenure, String loanType);
}