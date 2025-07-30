package com.model;

import org.springframework.stereotype.Component;

@Component
public class Registration {

    private String studentName;
    private int age;
    private String phoneNumber;
    private String optedSports;

    // Getters and Setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getOptedSports() { return optedSports; }
    public void setOptedSports(String optedSports) { this.optedSports = optedSports; }
}
