package com.spring.app;


import java.util.List;

import org.springframework.stereotype.Component;

//use appropriate annotation to make this class as component class 
@Component
public class Department {
	
	private int departmentId;
	private List<Staff> staffs;
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	
	/* Write a two argument constructor which accepts departmentId and list of 
	                                                  staffs as the parameters */
	
	public Department(int departmentId, List<Staff> staffs) {
		super();
		this.departmentId = departmentId;
		this.staffs = staffs;
	}

	public void displayStaffDetails() {
		System.out.println("Staff Details:");
		for (Staff s : staffs) {
			System.out.println("Staff Id:" + s.getStaffId());
			System.out.println("Staff Name:" + s.getStaffName());
			System.out.println("Contact Number:" + s.getContactNo());
			System.out.println("Department Name:" + s.getDepartmentName());
			System.out.println("Department Id:" + this.departmentId);
		}
	}
	
}
