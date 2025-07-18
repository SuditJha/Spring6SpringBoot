package com.cts.handson;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cts.handson.dao.EBillDAO;
import com.cts.handson.model.EBill;

@ComponentScan("com.cts.handson")
public class ElectricityBillApplication {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
        EBillDAO dao = appContext.getBean(EBillDAO.class);
        
                dao.deleteBill(100, 99);
        
        System.out.format("%-5s %-15s %-10s %10s %5s %s\n", "Id","Consumer Id","Month","Reading","Unit","Amount");
        
                List<EBill> bills = dao.getAllBill();
        for (EBill bill : bills) {
            System.out.println(bill);
        }
    }
}