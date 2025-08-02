package com.controller;

import java.util.List;

import javax.print.attribute.standard.Severity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Event;
import com.service.EventService;

@RestController
@RequestMapping("/OEMS")
public class EventController {	
	
	
		@Autowired
	    private EventService service;
	 
	@PutMapping("/updateEventType/{eventId}/{type}")
    public boolean updateEventType(@PathVariable("eventId") Integer eventId,@PathVariable("type") String eventType) {
        return service.updateEventType(eventId, eventType);
    }

   @DeleteMapping("/deleteEvent/{id}")
    public boolean deleteEvent(@PathVariable("id") Integer eventId) {
        return service.deleteEvent(eventId);
    }
	
}
	 	  	    	    		        	 	
