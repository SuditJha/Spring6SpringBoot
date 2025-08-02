package com.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.model.Event;

@Component
public class EventService {

	ArrayList<Event> eventList = new ArrayList<Event>();
	
	

	public ArrayList<Event> getEventList() {
		return eventList;
	}

	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}

	public EventService(){
		Event eventObj1 = new Event(1, "Tech Conference", "Conference", "2024-03-15");
        	Event eventObj2 = new Event(2, "Music Festival", "Festival", "2024-06-20");
       		Event eventObj3 = new Event(3, "Art Exhibition", "Exhibition", "2024-09-10");
        	Event eventObj4 = new Event(4, "Literature Workshop", "Workshop", "2024-11-05");
       		eventList.add(eventObj1);
        	eventList.add(eventObj2);
        	eventList.add(eventObj3);
        	eventList.add(eventObj4);
		
	}
	
	 public boolean addEvent(Event eventObj) {
	        return eventList.add(eventObj);
	    }
	
	
	
	 public Event findEventById(int eventId) {
	
		 for(Event e : eventList) {
			 if(e.getEventId()==eventId) {
				 return e;
			 }
		 }
	        
	        return null;
	    }
	 
	 public ArrayList<Event> findAllEvents() {
	        return eventList;
	    } 	
	
}
