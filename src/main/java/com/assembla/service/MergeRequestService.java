package com.assembla.service;

import com.assembla.MergeRequest;
import com.assembla.MergeRequest.Status;
import com.assembla.MergeRequestComment;
import com.assembla.Ticket;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.utils.ValidationUtils;

public class MergeRequestService extends AbstractBaseService {

	private int spaceToolId;

	public MergeRequestService(AssemblaClient assemblaClient, String spaceId, int spaceToolId) {
		super(assemblaClient, spaceId);
		this.spaceToolId = spaceToolId;
	}

	public PagedIterator<MergeRequest> mergeRequests() {
		String uri = String.format(AssemblaConstants.MERGE_REQUESTS, this.spaceId, this.spaceToolId);
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, MergeRequest[].class);
		return new PagedIterator<>(request, super.client);
	}

	public int getSpaceToolId() {
		return spaceToolId;
	}

	public void setSpaceToolId(int spaceToolId) {
		this.spaceToolId = spaceToolId;
	}

	public PagedIterator<MergeRequest> mergeRequests(Paging paging, Status status) {
		String uri = String.format(AssemblaConstants.MERGE_REQUESTS, this.spaceId, this.spaceToolId);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, MergeRequest[].class);
		} else {
			request = new PagedAssemblaRequest(uri, MergeRequest[].class, paging.page(), paging.size());
		}
		request.addParam("status", status.toString().toLowerCase());
		return new PagedIterator<>(request, client);
	}

	public MergeRequest create(MergeRequest mergeRequest) {
		ValidationUtils.notNull(mergeRequest, "mergeRequest == null");
		String uri = String.format(AssemblaConstants.MERGE_REQUESTS, this.spaceId, this.spaceToolId);
		AssemblaRequest request = new AssemblaRequest(uri, MergeRequest.class);
		request.withBody(mergeRequest);
		return super.post(request);
	}

	public MergeRequest get(int id) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_BY_ID, this.spaceId, this.spaceToolId, id);
		AssemblaRequest request = new AssemblaRequest(uri, MergeRequest.class);
		return super.get(request, String.format("Merge Request with id %d does not exist", id));
	}

	public PagedIterator<MergeRequestComment> getComments(int mergeRequestId, Paging paging) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_COMMENTS, this.spaceId, this.spaceToolId, mergeRequestId);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, MergeRequestComment[].class);
		} else {
			request = new PagedAssemblaRequest(uri, MergeRequestComment[].class, paging.page(), paging.size());
		}
		return new PagedIterator<>(request, client);
	}

	public void mergeAndClose(int id) {
		String uri = String.format(AssemblaConstants.MERGE_AND_CLOSE, this.spaceId, this.spaceToolId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.put(request);
	}

	public void ignore(int id) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_IGNORE, this.spaceId, this.spaceToolId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.put(request);
		
	}

	public PagedIterator<Ticket> associatedTickets(int id, Paging paging) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_TICKETS, this.spaceId, this.spaceToolId, id);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, Ticket[].class);
		} else {
			request = new PagedAssemblaRequest(uri, Ticket[].class, paging.page(), paging.size());
		}
		return new PagedIterator<>(request, client);
	}

}
