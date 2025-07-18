package com.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;

@Configuration
@ComponentScan(basePackages = "com.hotel")
@PropertySource("classpath:details.properties")
@Import(ConversionConfig.class)
public class ApplicationConfig {
    public static void main(String[] args) throws ParseException {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        
        ReservationService reservationService = context.getBean(ReservationService.class);
        Reservation reservation = context.getBean(Reservation.class);
        
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.println("Enter the Customer Name");
        String customerName = scanner.nextLine();
        reservation.setCustomerName(customerName);
        
        System.out.println("Enter the Phone Number");
        Long phoneNumber = scanner.nextLong();
        reservation.setPhoneNumber(phoneNumber);
        
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter the Check-In Date <dd-MM-yyyy>");
        String checkInDateStr = scanner.nextLine();
        reservation.setCheckInDate(dateFormat.parse(checkInDateStr));
        
        System.out.println("Enter the Check-Out Date <dd-MM-yyyy>");
        String checkOutDateStr = scanner.nextLine();
        reservation.setCheckOutDate(dateFormat.parse(checkOutDateStr));
        
        System.out.println("Enter the Total Number of Guests");
        int numOfGuests = scanner.nextInt();
        reservation.setNumOfGuests(numOfGuests);
        
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter the Room Type");
        String roomType = scanner.nextLine();
        reservation.setRoomType(roomType);
        
        reservationService.bookReservation(reservation);
        
        scanner.close();
    }
}