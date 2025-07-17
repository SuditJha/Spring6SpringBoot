package com.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//use appropriate annotation to make this class as component class 
@Component
public class NewYorkHospital implements HeadHospital {

    private Document newYorkDocument;
        
    //use appropriate annotation 
    @Autowired
    public NewYorkHospital(Document newYorkDocument) {
        super();
        this.newYorkDocument = newYorkDocument;
    }

	@Override
	public void doDocumentVerification() {
		// TODO Auto-generated method stub
		String idProof = newYorkDocument.getIdProof();
		System.out.println("Document verification done using " + idProof);
		
		
	}

	@Override
	public void provideTreatment() {
		// TODO Auto-generated method stub
		String condition = newYorkDocument.getCondition();
		String name = newYorkDocument.getName();
		System.out.printf("Treatment is in progress for %s with condition %s at New York Hospital\n", name, condition);
		
	}

   // FILL THE CODE HERE
}
