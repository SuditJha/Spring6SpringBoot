package com.spring.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Component
public class Ticket {

	@NotEmpty(message="Name cannot be empty")
	private String customer;
	@NotEmpty
	private String contactNumber;
	@Min(value = 1)
	private int noOfTicket;
	private String ticketType;
	private String refreshment;
	
//	Getters Setters
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getNoOfTicket() {
		return noOfTicket;
	}
	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getRefreshment() {
		return refreshment;
	}
	public void setRefreshment(String refreshment) {
		this.refreshment = refreshment;
	}
	
	
	
}
