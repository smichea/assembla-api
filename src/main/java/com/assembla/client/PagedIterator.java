package com.assembla.client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public final class PagedIterator<T> implements Iterator<Collection<T>>, Iterable<Collection<T>> {

	//Next request to execute
	private PagedAssemblaRequest request;
	//Last request executed
	private PagedAssemblaRequest lastRequest;
	// Client
	private final AssemblaClient client;

	public PagedIterator(PagedAssemblaRequest pagedRequest, AssemblaClient client) {
		if (pagedRequest == null || client == null) {
			throw new IllegalArgumentException("pagedRequest == null || client == null");
		}
		this.request = pagedRequest;
		this.client = client;
	}

	@Override
	public Iterator<Collection<T>> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return !request.equals(lastRequest);
	}

	@Override
	public Collection<T> next() {
		AssemblaResponse response = client.doGet(request);
		lastRequest = request;
		Optional<T[]> list = response.getValue();
		List<T> items = Collections.emptyList();
		if (list.isPresent()) {
			items = new ArrayList<>(Arrays.asList(list.get()));
			request = new PagedAssemblaRequest(
				request.getUri(), 
				request.getType().get(), 
				request.getPage() + 1,
				request.getPageSize()
			);
		}
		return items;
	}

	public AssemblaClient getClient() {
		return this.client;
	}

	public PagedAssemblaRequest getRequest() {
		return request;
	}

}
