package com.spring.app;

import org.springframework.stereotype.Component;

@Component
public class Loan {

	private String loanType;
	private double loanAmount;
	
	public Loan(String loanType, double loanAmount) {
		this.loanAmount = loanAmount;
		this.loanType = loanType;
	}	

	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
}
