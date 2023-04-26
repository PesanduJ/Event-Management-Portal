package com.eventmanagementportal.eventmanagementportal.service;

import com.eventmanagementportal.eventmanagementportal.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();

    Event addEvent(Event event);

    Event getEventById(Long id);

    Event updateEvent (Event event);
}
