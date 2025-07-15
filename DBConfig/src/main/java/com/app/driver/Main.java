package com.app.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.ApplicationConfig;
import com.spring.app.DBConfig;
import com.spring.app.StudentDAO;

public class Main {
 
	public static void main(String[] args) {
 
		ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentDAO dao = container.getBean(StudentDAO.class);
		DBConfig db = dao.getDbConfig();
		System.out.println(db.getDriverName());
		System.out.println(db.getUrl());
		System.out.println(db.getUserName());
		System.out.println(db.getPassword());
	}
}