package com.assembla.service;

import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.client.PagedIterator;

public interface TagResource {

	PagedIterator<Tag> getAll();

	PagedIterator<Tag> getActive();

	PagedIterator<Tag> getProposed();

	PagedIterator<Tag> getHidden();

	PagedIterator<Ticket> getTickets(Tag tag);

	Tag get(int id);

	Tag create(Tag tag);

	void update(Tag tag);

	void delete(Tag tag);

}
