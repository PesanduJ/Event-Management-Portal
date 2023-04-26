package com.eventmanagementportal.eventmanagementportal.service;

import com.eventmanagementportal.eventmanagementportal.entity.BookedEvent;

import java.util.List;

public interface BookedEventService {

    BookedEvent bookEvent(BookedEvent bookedEvent);

    List<BookedEvent> getAllBookedEvents();
}
