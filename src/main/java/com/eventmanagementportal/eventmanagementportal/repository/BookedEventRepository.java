package com.eventmanagementportal.eventmanagementportal.repository;

import com.eventmanagementportal.eventmanagementportal.entity.BookedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedEventRepository extends JpaRepository<BookedEvent, Long> {
}
