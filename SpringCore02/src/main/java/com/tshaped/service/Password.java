package com.tshaped.service;

public class Password {

	private String algo;
	public Password(String algo) {
		super();
		System.out.println("Password bean Created");
		this.algo = algo;
		
	}
	
	public String aboutAlgo() {
		return "Algo is " + algo;
	}

}
