package com.spring.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//use appropriate annotation to make this class as component class 
@Component
public class LEDLighting extends LightingSystem {
	
    //use appropriate annotation
	@Value("1600")
    private int luminosity;
    //use appropriate annotation
	@Value("10")
    private int energyConsumption;
    //use appropriate annotation
	@Value("led")
    private String type;
    

	public int getLuminosity() {
		return luminosity;
	}

	
	public void setLuminosity(int luminosity) {
		this.luminosity = luminosity;
	}

	public int getEnergyConsumption() {
		return energyConsumption;
	}

	 
   
	public void setEnergyConsumption(int energyConsumption) {
		this.energyConsumption = energyConsumption;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int getEfficiencyRating() {
			
	    // FILL THE CODE HERE
		
	    return luminosity / energyConsumption;
	}

	

}
