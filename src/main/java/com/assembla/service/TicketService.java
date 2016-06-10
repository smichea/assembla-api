package com.assembla.service;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assembla.CustomReport;
import com.assembla.Document;
import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.utils.ValidationUtils;

public class TicketService extends AbstractBaseService {

	public TicketService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public Ticket getTicketById(String id) {
		String uri = format(AssemblaConstants.TICKET_BY_ID, super.getSpaceId(), id);
		AssemblaRequest request = new AssemblaRequest(uri, Ticket.class);
		return super.get(request, format("No ticket with id %s exists", id));
	}

	public Ticket getTicketByNumber(int number) {
		String uri = format(AssemblaConstants.TICKET_BY_NUMBER, super.getSpaceId(), number);
		AssemblaRequest request = new AssemblaRequest(uri, Ticket.class);
		return super.get(request, format("No ticket with id %d exists", number));
	}

	public PagedIterator<Ticket> getTicketsByNoMilestone() {
		String uri = format(AssemblaConstants.TICKETS_BY_NO_MILESTONE, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Ticket[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Ticket> getAllTickets() {
		String uri = format(AssemblaConstants.TICKETS_BY_SPACE, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Ticket[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Ticket> getAllFollowedTickets() {
		String uri = format(AssemblaConstants.TICKETS_FOLLOWED, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Ticket[].class);
		return new PagedIterator<>(request, client);
	}

	public List<Ticket> getAllActiveTickets() {
		String uri = format(AssemblaConstants.TICKETS_BY_STATUS, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, Ticket[].class);
		return super.getList(request);
	}

	public List<Tag> getAllTagsForTicket(int ticketNumber) {
		String uri = format(AssemblaConstants.TAGS_FOR_TICKET, super.getSpaceId(), ticketNumber);
		AssemblaRequest request = new AssemblaRequest(uri, Tag[].class);
		return super.getList(request);
	}

	public List<Document> getAttachmentsForTicket(int ticketNumber) {
		String uri = format(AssemblaConstants.ATTACHMENTS_FOR_TICKET, super.getSpaceId(), ticketNumber);
		AssemblaRequest request = new AssemblaRequest(uri, Document[].class);
		return super.getList(request);
	}

	public void updateTicket(Ticket ticket) {
		ValidationUtils.notNull(ticket, "ticket == null");
		ValidationUtils.notNull(ticket.getNumber(), "ticket requires a number");

		String uri = format(AssemblaConstants.TICKET_BY_NUMBER, super.getSpaceId(), ticket.getNumber());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(ticket);
		client.put(request);
	}

	public CustomReport getCustomReports() {
		String uri = format(AssemblaConstants.TICKET_CUSTOM_REPORTS, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, CustomReport.class);
		return super.get(request, "Error getting custom reports");
	}

	public void deleteTicket(Ticket ticket) {
		ValidationUtils.notNull(ticket, "ticket == null");
		ValidationUtils.notNull(ticket.getNumber(), "ticket requires a number");

		String uri = format(AssemblaConstants.TICKET_DELETE, super.getSpaceId(), ticket.getNumber());
		AssemblaRequest request = new AssemblaRequest(uri);
		client.delete(request);
	}

	public Ticket createTicket(Ticket ticket) {
		String uri = format(AssemblaConstants.TICKETS_BY_SPACE, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, Ticket.class);
		request.withBody(ticket);
		return super.post(request);
	}

	public PagedIterator<Ticket> get(TicketRequest request) {
		String uri = format(AssemblaConstants.TICKETS_BY_SPACE, super.getSpaceId());
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest(
			uri,
			Ticket[].class, 
			request.getPageNumber(), 
			request.getPageSize()
		);

		Map<String, Object> params = new HashMap<>();
		request.getReport().ifPresent(x -> params.put(AssemblaConstants.REPORT_PARAMETER, x));
		request.getSortBy().ifPresent(x -> params.put(AssemblaConstants.SORT_BY_PARAMETER, x));
		request.getDirection().ifPresent(x -> params.put(AssemblaConstants.SORT_DIRECTION_PARAMETER, x.getValue()));
		pagedRequest.addAllParameters(params);
		
		return new PagedIterator<>(pagedRequest, client);
	}

	public PagedIterator<Ticket> getByMilestone(String milestoneId, TicketRequest request) {
		ValidationUtils.notNull(milestoneId, "milestoneId == null");
		String uri = String.format(AssemblaConstants.TICKET_BY_MILESTONE, this.spaceId, milestoneId);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest(
			uri,
			Ticket[].class, 
			request.getPageNumber(), 
			request.getPageSize()
		);

		Map<String, Object> params = new HashMap<>();
		request.getStatus().ifPresent(x -> params.put(AssemblaConstants.TICKET_STATUS_PARAMETER, x.getValue()));
		request.getSortBy().ifPresent(x -> params.put(AssemblaConstants.SORT_BY_PARAMETER, x));
		request.getDirection().ifPresent(x -> params.put(AssemblaConstants.SORT_DIRECTION_PARAMETER, x.getValue()));
		pagedRequest.addAllParameters(params);

		return new PagedIterator<>(pagedRequest, this.client);
	}

}
