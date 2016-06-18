package com.assembla.service;

import java.util.List;

import com.assembla.CustomReport;
import com.assembla.Document;
import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.client.PagedIterator;

public interface TicketResource {

	Ticket getById(String id);

	Ticket getByNumber(int number);

	PagedIterator<Ticket> getNoMilestone();

	PagedIterator<Ticket> getAll();

	PagedIterator<Ticket> getFollowed();

	List<Ticket> getActive();

	List<Tag> getTags(int ticketNumber);

	List<Document> getAttachments(int ticketNumber);

	void update(Ticket ticket);

	CustomReport getCustomReports();

	void delete(Ticket ticket);

	Ticket create(Ticket ticket);

	PagedIterator<Ticket> get(TicketRequest request);

	PagedIterator<Ticket> getByMilestone(String milestoneId, TicketRequest request);

}
