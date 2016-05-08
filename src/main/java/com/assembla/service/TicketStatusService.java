package com.assembla.service;

import java.util.List;

import static java.lang.String.format;

import com.assembla.TicketStatus;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.utils.ObjectUtils;

public class TicketStatusService extends AbstractBaseService {

	public TicketStatusService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public List<TicketStatus> getAll() {
		String uri = format(AssemblaConstants.TICKET_STATUS_ALL, super.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, TicketStatus[].class);
		return super.getList(request);
	}

	public TicketStatus get(int id) {
		String uri = format(AssemblaConstants.TICKET_STATUS_ID, super.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri, TicketStatus.class);
		return super.get(request, format("No TicketStatus with id : %d", id));
	}

	public TicketStatus create(TicketStatus status) {
		ObjectUtils.notNull(status, "ticketStatus == null");
		String uri = format(AssemblaConstants.TICKET_STATUS_ALL, super.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, TicketStatus.class);
		request.withBody(status);
		return super.post(request);
	}

	public void update(TicketStatus ticketStatus) {
		ObjectUtils.notNull(ticketStatus, "ticketStatus == null");
		ObjectUtils.notNull(ticketStatus.getId(), "ticketStatus must have an id");
		String uri = format(AssemblaConstants.TICKET_STATUS_ID, super.spaceId, ticketStatus.getId());
		AssemblaRequest request = new AssemblaRequest(uri, TicketStatus.class);
		request.withBody(ticketStatus);
		super.client.doPut(request);
	}

	public void delete(TicketStatus ticketStatus) {
		ObjectUtils.notNull(ticketStatus, "ticketStatus == null");
		ObjectUtils.notNull(ticketStatus.getId(), "ticketStatus must have an id");
		String uri = format(AssemblaConstants.TICKET_STATUS_ID, super.spaceId, ticketStatus.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.doDelete(request);
	}

}
