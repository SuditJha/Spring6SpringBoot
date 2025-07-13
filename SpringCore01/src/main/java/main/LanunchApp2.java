package main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.ICourse;
import services.Java;
import services.SpringBoot;
import services.TShapedSkills;

public class LanunchApp2 {
	
	public static void main(String args[]) {
		
		// Bean Factory
		DefaultListableBeanFactory container = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader read =new XmlBeanDefinitionReader(container);
		read.loadBeanDefinitions("ApplicationConfig.xml");
		
		
		
		
		TShapedSkills t = container.getBean(TShapedSkills.class);
		boolean status = t.buyTheCourse(6999.0);
		if(status) {
			System.out.println("Successfully purchased course");
		}else {
			System.out.println("Failed to buy Course");
		}
	
		
	}
	
	
}    
