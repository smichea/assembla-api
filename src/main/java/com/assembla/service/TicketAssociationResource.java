package com.assembla.service;

import java.util.List;

import com.assembla.Ticket;
import com.assembla.TicketAssociation;

public interface TicketAssociationResource {

	List<TicketAssociation> get(Ticket ticket);

	TicketAssociation getById(Ticket ticket, int id);

	TicketAssociation create(Ticket ticket, TicketAssociation association);

	void update(Ticket ticket, TicketAssociation association);

	void delete(Ticket ticket, TicketAssociation association);

}
