package com.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.exception.UnavailableCollegeException;
import com.model.College;

@Service
public class CollegeService {

    ArrayList<College> collegeList = new ArrayList<College>();

    public ArrayList<College> searchCollege(College college) throws UnavailableCollegeException {
        ArrayList<College> result = new ArrayList<>();
        String inputCourse = college.getOfferingCourse().toLowerCase();
        double inputFees = college.getAnnualFees();

        for (College c : collegeList) {
            if (c.getOfferingCourse().equalsIgnoreCase(inputCourse) && c.getAnnualFees() <= inputFees) {
                result.add(c);
            }
        }

        if (result.isEmpty()) {
            throw new UnavailableCollegeException("Sorry!! No colleges are available for the course " 
                + college.getOfferingCourse() + " with in the given fees range");
        }

        return result;
    }

    public CollegeService() {
        addColleges();
    }

    public void addColleges() {
        collegeList.add(new College("IIT Kanpur", "Kanpur", "Engineering", 10000));
        collegeList.add(new College("HCS Womens college ", "Delhi", "BCA", 15000));
        collegeList.add(new College("Vidya", "Kerala", "Engineering", 65000));
        collegeList.add(new College("IIM", "Ahmedabad", "MBA", 85000));
        collegeList.add(new College("MTET", "Coimbatore", "BArch", 100000));
        collegeList.add(new College("CET", "Kerala", "Engineering", 20000));
        collegeList.add(new College("Christ", "Bangalore", "Bcom", 50000));
        collegeList.add(new College("AIIMS", "Delhi", "MBBS", 200000));
        collegeList.add(new College("Loyala", "Chennai", "Bcom", 25000));
        collegeList.add(new College("Symbiosis Law School", "Pune", "BArch", 150000));
    }
}
