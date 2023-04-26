package com.eventmanagementportal.eventmanagementportal.controller;

import com.eventmanagementportal.eventmanagementportal.entity.BookedEvent;
import com.eventmanagementportal.eventmanagementportal.entity.Event;
import com.eventmanagementportal.eventmanagementportal.service.BookedEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class BookedEventController {

    @Autowired
    private BookedEventService bookedEventService;

    @PostMapping("/bill")
    public String showBill(@ModelAttribute("eventItem") Event event, Model model) {
        String eventName = event.getName();
        String eventLocation = event.getLocation();
        String eventTicket = String.valueOf(event.getTicket());

        //generating a pass
        String eventPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

        //save to booked events database
        BookedEvent bookEvent = new BookedEvent();
        bookEvent.setName(eventName);
        bookEvent.setLocation(eventLocation);
        bookEvent.setTicket(Float.parseFloat(eventTicket));
        bookEvent.setPass(eventPass);
        bookedEventService.bookEvent(bookEvent);


        // add the event information to the model
        model.addAttribute("eventName", eventName);
        model.addAttribute("eventLocation", eventLocation);
        model.addAttribute("eventTicket", eventTicket);
        model.addAttribute("eventPass", eventPass);
        return "bill";
    }

    @GetMapping("/bookedTickets")
    public String listOfBookedEvents(Model model){
        List<BookedEvent> soldItemList = bookedEventService.getAllBookedEvents();

        model.addAttribute("bookedEventList", soldItemList);

        return "booked_events";
    }

}
