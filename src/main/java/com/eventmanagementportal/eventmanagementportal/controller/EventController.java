package com.eventmanagementportal.eventmanagementportal.controller;

import com.eventmanagementportal.eventmanagementportal.entity.Event;
import com.eventmanagementportal.eventmanagementportal.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public String listOfEvents(Model model){
        model.addAttribute("eventList", eventService.getAllEvents());
        return "events";
    }

    //Add items to database
    @GetMapping("/addEvent/new")
    public String createAddEventForm(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "add_events";
    }

    @PostMapping("/addEvent")
    public String addEvents(@ModelAttribute("event")Event event){
        eventService.addEvent(event);
        return "redirect:/events";
    }


}
