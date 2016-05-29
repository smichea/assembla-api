package com.assembla.service;

import static java.lang.String.format;

import com.assembla.Ticket;
import com.assembla.TicketComment;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.utils.ValidationUtils;

public class TicketCommentService extends AbstractBaseService {

	public TicketCommentService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public PagedIterator<TicketComment> getTicketComments(Ticket ticket) {
		ValidationUtils.notNull(ticket, "ticket == null");
		ValidationUtils.notNull(ticket.getNumber(), "ticket requires a number");

		String uri = format(AssemblaConstants.TICKET_COMMENTS_FOR_TICKET, super.getSpaceId(), ticket.getNumber());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, TicketComment[].class);
		return new PagedIterator<TicketComment>(request, client);

	}

	public TicketComment getTicketComment(Ticket ticket, int commentId) {
		String uri = format(AssemblaConstants.TICKET_COMMENT, super.getSpaceId(), ticket.getNumber(), commentId);
		AssemblaRequest request = new AssemblaRequest(uri, TicketComment.class);
		return super.get(request, format("No ticket with id %d for ticket %d exists", commentId, ticket.getNumber()));
	}

	public TicketComment createTicketComment(Ticket ticket, TicketComment newTicketComment) {
		String uri = format(AssemblaConstants.TICKET_COMMENTS_FOR_TICKET, super.getSpaceId(), ticket.getNumber());
		AssemblaRequest request = new AssemblaRequest(uri, TicketComment.class);
		request.withBody(newTicketComment);
		return super.post(request);
	}

	public void updateTicketComment(Ticket ticket, TicketComment ticketComment) {
		ValidationUtils.notNull(ticket, "ticket == null");
		ValidationUtils.notNull(ticketComment, "ticketComment == null");
		ValidationUtils.notNull(ticket.getNumber(), "ticket requires a number");
		ValidationUtils.notNull(ticketComment.getId(), "ticketComment requires an id");

		String uri = format(AssemblaConstants.TICKET_COMMENT, super.getSpaceId(), ticket.getNumber(), ticketComment.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(ticketComment);
		client.put(request);
	}

}
