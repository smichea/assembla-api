package com.assembla.service;

import java.util.Collections;
import java.util.List;

import com.assembla.MergeRequestComment;
import com.assembla.MergeRequestCommentMessage;
import com.assembla.MergeRequestVersion;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;

public class MergeRequestVersionService extends AbstractBaseService {

	private int spaceToolId;

	public MergeRequestVersionService(AssemblaClient assemblaClient, String testSpaceId, int spaceToolId) {
		super(assemblaClient, testSpaceId);
		this.spaceToolId = spaceToolId;
	}

	public List<MergeRequestVersion> versions(int id) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_VERSIONS, this.spaceId, this.spaceToolId, id);
		AssemblaRequest request = new AssemblaRequest(uri, MergeRequestVersion[].class);
		return super.getList(request);
	}

	public MergeRequestVersion get(int id, int version) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_VERSION, this.spaceId, this.spaceToolId, id, version);
		AssemblaRequest request = new AssemblaRequest(uri, MergeRequestVersion.class);
		return super.get(request, String.format("No Merge Request Version for id %d at version %d", id, version));
	}

	public MergeRequestVersion create(int id) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_VERSIONS, this.spaceId, this.spaceToolId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		return super.post(request);
	}

	public PagedIterator<MergeRequestComment> getComments(int id, int version, Paging paging) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_VERSION_COMMENTS, this.spaceId, this.spaceToolId, id,
				version);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, MergeRequestComment[].class);
		} else {
			request = new PagedAssemblaRequest(uri, MergeRequestComment[].class, paging.page(), paging.size());
		}
		return new PagedIterator<>(request, client);
	}

	public MergeRequestComment createComment(int id, int version, String message) {
		String uri = String.format(AssemblaConstants.MERGE_REQUEST_VERSION_COMMENTS, this.spaceId, this.spaceToolId, id,
				version);
		AssemblaRequest request = new AssemblaRequest(uri, MergeRequestComment.class);
		request.withBody(new MergeRequestCommentMessage(message));
		return super.post(request);
	}

}
