package com.model;

public class Patient {
	
	 private int patientId;
	    private String name;
	    private String diagnosis;
	    private String admissionDate;
	    private String status;

	    public Patient() {
	        // Default constructor
	    }

	    public Patient(int patientId, String name, String diagnosis, String admissionDate, String status) {
	        this.patientId = patientId;
	        this.name = name;
	        this.diagnosis = diagnosis;
	        this.admissionDate = admissionDate;
	        this.status = status;
	    }

	    public int getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(int patientId) {
	        this.patientId = patientId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDiagnosis() {
	        return diagnosis;
	    }

	    public void setDiagnosis(String diagnosis) {
	        this.diagnosis = diagnosis;
	    }

	    public String getAdmissionDate() {
	        return admissionDate;
	    }

	    public void setAdmissionDate(String admissionDate) {
	        this.admissionDate = admissionDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
