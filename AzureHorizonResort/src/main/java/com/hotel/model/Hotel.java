package com.hotel.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    @Value("${hotelName}")
    private String hotelName;
    
    @Value("${location}")
    private String location;
    @Value("${hotel.roomRates}")
    private Map<String, Double> roomRates;
    public Hotel() {
       
    }
    public String getHotelName() {
        return hotelName;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Map<String, Double> getRoomRates() {
        return roomRates;
    }
    
    public void setRoomRates(Map<String, Double> roomRates) {
        this.roomRates = roomRates;
    }
}