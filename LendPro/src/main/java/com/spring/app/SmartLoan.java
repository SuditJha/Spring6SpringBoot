package com.spring.app;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SmartLoan extends Loan {
	
		private Map<String, Double> interestRatesMap;
		
	 	public SmartLoan() {
	 	}
	 	public SmartLoan(int customerId, String customerName, Map<String, Double> interestRatesMap) {
			super(customerId, customerName);
			this.interestRatesMap = interestRatesMap;
			// TODO Auto-generated constructor stub
		}

		
		public Map<String, Double> getInterestRatesMap() {
			return interestRatesMap;
		}
		public void setInterestRatesMap(Map<String, Double> interestRatesMap) {
			this.interestRatesMap = interestRatesMap;
		}
		
		
		@Override
		public double calculateEMI(double loanAmount, int tenure, String loanType) {
			if (loanAmount > 0 && tenure > 0 && interestRatesMap.containsKey(loanType)) {
	            double annualRate = interestRatesMap.get(loanType);
	            double monthlyRate = annualRate / 12;
	            double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
	                         (Math.pow(1 + monthlyRate, tenure) - 1);
	            return Double.parseDouble(new DecimalFormat("#.##").format(emi));
	        } else {
	            return -1; // Invalid
	        }
		}

		
	 	
}
