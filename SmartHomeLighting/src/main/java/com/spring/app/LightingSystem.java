package com.spring.app;

public abstract class LightingSystem {
	
	private int luminosity;
	private int energyConsumption;
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

	public abstract int getEfficiencyRating();

	
	
}	 	  	    	    		        	 	
