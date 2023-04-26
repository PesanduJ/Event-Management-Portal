package com.eventmanagementportal.eventmanagementportal.service;

import com.eventmanagementportal.eventmanagementportal.entity.BookedEvent;
import com.eventmanagementportal.eventmanagementportal.repository.BookedEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookedEventServiceImpl implements BookedEventService{

    @Autowired
    private BookedEventRepository bookedEventRepository;

    @Override
    public BookedEvent bookEvent(BookedEvent bookedEvent) {
        return bookedEventRepository.save(bookedEvent);
    }

    @Override
    public List<BookedEvent> getAllBookedEvents() {
        return bookedEventRepository.findAll();
    }


}
