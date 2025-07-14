package com.spring.app;

import org.springframework.stereotype.Component;

//Provide the necessary annotations
@Component
public class Item {
	
	private String itemName;
	
	private double price;
	
		
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
