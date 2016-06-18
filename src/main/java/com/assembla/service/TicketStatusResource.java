package com.assembla.service;

import java.util.List;

import com.assembla.TicketStatus;

public interface TicketStatusResource {

	List<TicketStatus> getAll();

	TicketStatus get(int id);

	TicketStatus create(TicketStatus status);

	void update(TicketStatus ticketStatus);

	void delete(TicketStatus ticketStatus);

}
