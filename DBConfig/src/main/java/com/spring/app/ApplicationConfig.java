package com.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Provide the necessary annotations
@Configuration
@ComponentScan(basePackages="com.spring")
public class ApplicationConfig {

    //Provide the necessary annotations
	@Bean
    public DBConfig dbConfig() {
        //Fill the code
		DBConfig db = new DBConfig();
		db.setDriverName("oracle.jdbc.driver.OracleDriver");
		db.setUrl("jdbc:oracle:thin:@localhost:1521:oracle");
		db.setUserName("alex");
		db.setPassword("alex@123");
        
        return db;
    }

    //Provide the necessary annotations
	@Bean
    public StudentDAO studentDAO() {
        //Fill the code
		StudentDAO studentDAO = new StudentDAO();
        studentDAO.setDbConfig(dbConfig());
        return studentDAO;
    }
}
