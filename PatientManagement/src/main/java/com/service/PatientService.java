package com.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.model.Patient;

@Service
public class PatientService {
	ArrayList<Patient> patientList=new ArrayList<Patient>();
	
	
	
	
	public ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}

	public PatientService() {
		Patient p1 = new Patient(101, "John Doe", "Influenza", "2024-02-01", "Admitted");
		Patient p2 = new Patient(102, "Jane Doe", "Diabetes", "2024-02-05", "Under Observation");
		Patient p3 = new Patient(103, "Jim Beam", "Hypertension", "2024-02-10", "Discharged");
		Patient p4 = new Patient(104, "Jill Hill", "Asthma", "2024-02-15", "Admitted");

		patientList.add(p1);
		patientList.add(p2);
		patientList.add(p3);
		patientList.add(p4);
	}
	
	public Patient searchPatient(int patientId)
	{
		Patient p=null;
		for(Patient pObj: patientList)
		{
			if(pObj.getPatientId()==patientId)
			{
				p=pObj;
				break;
			}
		}
		return p;
	}

	
}
