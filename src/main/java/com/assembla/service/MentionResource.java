package com.assembla.service;

import java.util.List;

import com.assembla.Mention;

public interface MentionResource {

	List<Mention> getAll();

	List<Mention> getRead();

	List<Mention> getUnread();

	Mention get(int id);

	void markAsRead(int id);

}
