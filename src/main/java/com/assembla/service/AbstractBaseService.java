package com.assembla.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaRequest;
import com.assembla.exception.AssemblaAPIException;

public abstract class AbstractBaseService implements AssemblaService {

	protected final AssemblaClient client;
	protected String spaceId;

	public AbstractBaseService(AssemblaClient assemblaClient, String spaceId) {
		this.client = assemblaClient;
		this.spaceId = spaceId;
	}

	public AssemblaClient getClient() {
		return client;
	}

	public String getSpaceId() {
		return spaceId;
	}

	protected final <E> E post(AssemblaRequest request) {
		try {
			return client.doPost(request).<E> getValue().orElse(null);
		} catch (AssemblaAPIException ae) {
			return null;
		}
	}

	protected final <E> E get(AssemblaRequest request, String errMessage) {
		return client.doGet(request).<E> getValue()
				.orElseThrow(() -> new AssemblaAPIException(errMessage));
	}

	protected final <E> List<E> getList(AssemblaRequest request) {
		return client.doGet(request).<E[]> getValue()
				.map(Arrays::asList)
				.orElseGet(Collections::emptyList);
	}

}
