package com.assembla.service;

import java.time.LocalDateTime;

import com.assembla.Event;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;

public class ActivityService extends AbstractBaseService {

	public ActivityService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public PagedIterator<Event> get() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(AssemblaConstants.ACTIVITY, Event[].class);
		return new PagedIterator<>(request, super.client);
	}

	public PagedIterator<Event> get(LocalDateTime start, LocalDateTime end) {
		DateRange range = new DateRange(start, end);
		PagedAssemblaRequest request = new PagedAssemblaRequest(AssemblaConstants.ACTIVITY, Event[].class);
		request.addParam(AssemblaConstants.DATE_FROM_PARAMETER, range.getFromString());
		request.addParam(AssemblaConstants.DATE_TO_PARAMETER, range.getToString());
		return new PagedIterator<>(request, client);
	}

}
