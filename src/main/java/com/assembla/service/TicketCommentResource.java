package com.assembla.service;

import com.assembla.Ticket;
import com.assembla.TicketComment;
import com.assembla.client.PagedIterator;

public interface TicketCommentResource {

	PagedIterator<TicketComment> getAll(Ticket ticket);

	TicketComment getById(Ticket ticket, int commentId);

	TicketComment create(Ticket ticket, TicketComment newTicketComment);

	void update(Ticket ticket, TicketComment ticketComment);

}
