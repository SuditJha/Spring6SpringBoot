package com.spring.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.context.ApplicationContext;

@Configuration // ✅ Fail 3 Fix
@ComponentScan("com.spring.app") // ✅ Fail 4 Fix
@PropertySource("classpath:goldRateDetails.properties") // ✅ Fail 1 Fix
public class Driver {

    public static GoldRateInfo loadGoldRateDetails() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);
        GoldRateInfo info = context.getBean(GoldRateInfo.class);
        return info;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the carat:");
        int carat = in.nextInt();

        System.out.println("Enter Total Grams:");
        double grams = in.nextDouble();

        GoldRateInfo info = loadGoldRateDetails();
        double result = info.calculateGoldRate(carat, grams);

        System.out.println("Total Gold Rate is Rs:" + result);
        in.close();
    }
}
