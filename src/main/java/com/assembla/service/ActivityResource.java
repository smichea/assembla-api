package com.assembla.service;

import java.time.LocalDateTime;

import com.assembla.Event;
import com.assembla.client.PagedIterator;

public interface ActivityResource {

	PagedIterator<Event> get();

	PagedIterator<Event> get(LocalDateTime start, LocalDateTime end);

}
