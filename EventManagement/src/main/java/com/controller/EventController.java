package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Event;
import com.service.EventService;

@RestController
@RequestMapping("/OEMS")
public class EventController {	

		@Autowired
	    private EventService service;
	 
	
		@PostMapping("/addEvent")
	    public boolean addEvent(@RequestBody Event eventObj) {
	        return service.addEvent(eventObj);
	    }
	
	    @GetMapping("/findEventById/{eventId}")
	    public Event findEventById(@PathVariable("eventId") int eventId) {
	        return service.findEventById(eventId);
	    }
	
	    @GetMapping("/findAllEvents")
	    public List<Event> findAllEvents() {
     	return service.findAllEvents();
	    }
	
	
}
	 	  	    	    		        	 	
