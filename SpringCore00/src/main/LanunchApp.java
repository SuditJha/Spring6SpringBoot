package main;

import services.ICourse;
import services.Java;
import services.SpringBoot;
import services.TShapedSkills;

public class LanunchApp {
	
	public static void main(String args[]) {
		TShapedSkills t = new TShapedSkills(new Java()); //target
//		t.setCourse(new Java());
//		t.setCourse(new SpringBoot()); // setter injection
		
//		ICourse course = new Java();
//		ICourse course2 = new SpringBoot();
		
		
		t.buyTheCourse(4999.0);
		
	}
}
