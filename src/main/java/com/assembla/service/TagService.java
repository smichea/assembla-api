package com.assembla.service;

import static java.lang.String.format;

import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.utils.ObjectUtils;

public class TagService extends AbstractBaseService {

	public TagService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public PagedIterator<Tag> getTags() {
		String uri = format(AssemblaConstants.TAGS, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Tag[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Tag> getActiveTags() {
		String uri = format(AssemblaConstants.ACTIVE_TAGS, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Tag[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Tag> getProposedTags() {
		String uri = format(AssemblaConstants.PROPOSED_TAGS, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Tag[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Tag> getHiddenTags() {
		String uri = format(AssemblaConstants.HIDDEN_TAGS, super.getSpaceId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Tag[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Ticket> getTicketsForTag(Tag tag) {
		ObjectUtils.notNull(tag, "tag == null");
		ObjectUtils.notNull(tag.getId(), "tag requires an id");
		
		String uri = format(AssemblaConstants.TICKETS_BY_TAG, super.getSpaceId(), tag.getId());
		PagedAssemblaRequest request = new PagedAssemblaRequest(uri, Tag[].class);
		return new PagedIterator<>(request, client);
	}

	public Tag getTag(int id) {
		String uri = format(AssemblaConstants.TAG_BY_ID, super.getSpaceId(), id);
		AssemblaRequest request = new AssemblaRequest(uri, Tag.class);
		return super.get(request, format("Error getting tag by id (%s)", id));
	}

	public Tag createTag(Tag tag) {
		ObjectUtils.notNull(tag, "tag == null");
		
		String uri = format(AssemblaConstants.TAGS, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, Tag.class);
		request.withBody(tag);
		return super.post(request);
	}

	public void updateTag(Tag tag) {
		ObjectUtils.notNull(tag, "tag == null");
		ObjectUtils.notNull(tag.getId(), "tag requires an id");

		String uri = format(AssemblaConstants.TAG_BY_ID, super.getSpaceId(), tag.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(tag);
		client.doPut(request);
	}

	public void deleteTag(Tag tag) {
		ObjectUtils.notNull(tag, "tag == null");
		ObjectUtils.notNull(tag.getId(), "tag requires an id");
		
		String uri = format(AssemblaConstants.TAG_BY_ID, super.getSpaceId(), tag.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		client.doDelete(request);
	}

}
