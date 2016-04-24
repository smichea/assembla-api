package com.assembla.service;
import static java.lang.String.format;

import com.assembla.Ticket;
import com.assembla.TicketComment;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;

public class TicketCommentService extends AbstractBaseService {

	public TicketCommentService(AssemblaClient assemblaClient) {
		super(assemblaClient);
	}

	public PagedIterator<TicketComment> getTicketComments(Ticket ticket) {
		if (ticket == null || ticket.getNumber() == null) {
			throw new IllegalArgumentException("ticket == null");
		}
		String uri = format(AssemblaConstants.TICKET_COMMENTS_FOR_TICKET, client.getSpaceId(), ticket.getNumber());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, TicketComment[].class);
		return new PagedIterator<TicketComment>(request, client);

	}

	public TicketComment getTicketComment(Ticket ticket, int commentId) {
		String uri = format(AssemblaConstants.TICKET_COMMENT, client.getSpaceId(), ticket.getNumber(), commentId);
		AssemblaRequest request = new AssemblaRequest(uri, TicketComment.class);
		return super.get(request,format("No ticket with id %d for ticket %d exists", commentId, ticket.getNumber()));
	}

	public TicketComment createTicketComment(Ticket ticket, TicketComment newTicketComment) {
		String uri = format(AssemblaConstants.TICKET_COMMENTS_FOR_TICKET, client.getSpaceId(), ticket.getNumber());
		AssemblaRequest request = new AssemblaRequest(uri, TicketComment.class);
		request.withBody(newTicketComment);
		return super.post(request);
	}

	public void updateTicketComment(Ticket ticket, TicketComment ticketComment) {
		if (ticket == null || ticketComment == null) {
			throw new IllegalArgumentException("ticket == null || ticketComment == null");
		}
		if(ticket.getNumber() == null || ticketComment.getId() == null) {
			throw new IllegalArgumentException("Ticket number of ticketComment id are null");
		}
		String uri = format(AssemblaConstants.TICKET_COMMENT, client.getSpaceId(), ticket.getNumber(), ticketComment.getId());
		AssemblaRequest request = new AssemblaRequest(uri, null);
		request.withBody(ticketComment);	
		client.doPut(request);
	}
	
}
