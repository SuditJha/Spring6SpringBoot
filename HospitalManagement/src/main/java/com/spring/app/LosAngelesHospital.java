package com.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//use appropriate annotation to make this class as component class 
@Component
public class LosAngelesHospital implements HeadHospital  {

    private Document losAngelesDocument;
    
    //use appropriate annotation 
    @Autowired
    public LosAngelesHospital(Document losAngelesDocument) {
        super();
        this.losAngelesDocument = losAngelesDocument;
    }

	@Override
	public void doDocumentVerification() {
		String idProof = losAngelesDocument.getIdProof();
		System.out.println("Document verification done using " + idProof);
		
	}

	@Override
	public void provideTreatment() {
		// TODO Auto-generated method stub
		String condition = losAngelesDocument.getCondition();
		String name = losAngelesDocument.getName();
		System.out.printf("Treatment is in progress for %s with condition %s at Los Angeles Hospital\n", name, condition);
		
		
	}

    // FILL THE CODE HERE
}
