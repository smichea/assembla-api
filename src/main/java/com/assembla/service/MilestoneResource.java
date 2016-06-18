package com.assembla.service;

import com.assembla.Milestone;
import com.assembla.client.PagedIterator;

public interface MilestoneResource {

	PagedIterator<Milestone> getUpcoming();

	PagedIterator<Milestone> getAll();

	PagedIterator<Milestone> getCompleted();

	PagedIterator<Milestone> getReleases();

	Milestone get(String milestoneId);

	Milestone create(Milestone milestoneToCreate);

	void update(Milestone milestone);

	void delete(Milestone milestone);

}
