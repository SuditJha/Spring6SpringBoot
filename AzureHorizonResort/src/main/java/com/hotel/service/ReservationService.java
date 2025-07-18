package com.hotel.service;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Hotel;
import com.hotel.model.Reservation;

@Service
public class ReservationService {
    
    @Autowired
    private Hotel hotel;
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public void bookReservation(Reservation reservation) throws ParseException {
        String roomType = reservation.getRoomType();
        Date checkInDate = reservation.getCheckInDate();
        Date checkOutDate = reservation.getCheckOutDate();
        
        double cost = calculateBookingCost(roomType, checkInDate, checkOutDate);
        
        if (cost > 0) {
            System.out.println("Total Booking Cost is: $" + cost);
        } else {
            System.out.println("Invalid Details");
        }
    }
    
    public double calculateBookingCost(String roomType, Date checkInDate, Date checkOutDate) {
        if (!checkAvailability(checkInDate, checkOutDate)) {
            return -1; 
        }
        
        if (!hotel.getRoomRates().containsKey(roomType)) {
            return -1;
        }
        
        long diffInMillies = checkOutDate.getTime() - checkInDate.getTime();
        long nights = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        
        double roomRate = hotel.getRoomRates().get(roomType);
        double totalCost = roomRate * nights;
        
        return totalCost;
    }
    
    public boolean checkAvailability(Date checkInDate, Date checkOutDate) {
        if (checkInDate.after(checkOutDate) || checkInDate.equals(checkOutDate)) {
            return false;
        }
        
        return true;
    }
}