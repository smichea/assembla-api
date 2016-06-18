package com.assembla.service;

import com.assembla.MergeRequest;
import com.assembla.MergeRequestComment;
import com.assembla.Ticket;
import com.assembla.MergeRequest.Status;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;

public interface MergeRequestResource {

	int getSpaceToolId();

	void setSpaceToolId(int spaceToolId);

	PagedIterator<MergeRequest> getAll();

	PagedIterator<MergeRequest> getAll(Paging paging, Status status);

	MergeRequest create(MergeRequest mergeRequest);

	MergeRequest get(int id);

	PagedIterator<MergeRequestComment> getComments(int mergeRequestId, Paging paging);

	void mergeAndClose(int id);

	void ignore(int id);

	PagedIterator<Ticket> associatedTickets(int id, Paging paging);

}
