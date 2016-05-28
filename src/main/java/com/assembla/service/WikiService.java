package com.assembla.service;

import com.assembla.WikiPage;
import com.assembla.WikiPageVersion;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.utils.ObjectUtils;

public class WikiService extends AbstractBaseService {

	public WikiService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public PagedIterator<WikiPage> getAll(Paging paging) {
		String uri = String.format(AssemblaConstants.WIKI_PAGES, this.spaceId);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, WikiPage[].class);
		} else {
			request = new PagedAssemblaRequest(uri, WikiPage[].class, paging.page(), paging.size());
		}
		return new PagedIterator<>(request, this.client);
	}

	public WikiPage get(String id) {
		ObjectUtils.notNull(id, "id == null");
		String uri = String.format(AssemblaConstants.WIKI_PAGE, this.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri, WikiPage.class);
		return super.get(request, String.format("No Wiki Page with id %s", id));
	}

	public WikiPage create(WikiPage page) {
		ObjectUtils.notNull(page, "page == null");
		String uri = String.format(AssemblaConstants.WIKI_PAGES, this.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, WikiPage.class);
		request.withBody(page);
		return super.post(request);
	}

	public void update(WikiPage page) {
		ObjectUtils.notNull(page, "page == null");
		ObjectUtils.notNull(page.getId(), "Wiki Page being updated requires an ID");
		String uri = String.format(AssemblaConstants.WIKI_PAGE, this.spaceId, page.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(page);
		super.client.doPut(request);
	}

	public void deleteAll(String id) {
		ObjectUtils.notNull(id, "id == null");
		String uri = String.format(AssemblaConstants.WIKI_PAGE_ALL, this.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.doDelete(request);
	}

	public void delete(String id) {
		ObjectUtils.notNull(id, "id == null");
		String uri = String.format(AssemblaConstants.WIKI_CONTAINER, this.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.doDelete(request);
	}

	public PagedIterator<WikiPageVersion> getVersions(String id, Paging paging) {
		String uri = String.format(AssemblaConstants.WIKI_PAGE_VERSIONS, this.spaceId, id);
		PagedAssemblaRequest request = null;
		if (paging == null) {
			request = new PagedAssemblaRequest(uri, WikiPageVersion[].class);
		} else {
			request = new PagedAssemblaRequest(uri, WikiPageVersion[].class, paging.page(), paging.size());
		}
		return new PagedIterator<>(request, client);
	}

	public WikiPageVersion getVersion(String id, String versionId) {
		ObjectUtils.notNull(id, "id == null");
		ObjectUtils.notNull(versionId, "versionId == null");
		String uri = String.format(AssemblaConstants.WIKI_PAGE_VERSION, this.spaceId, id, versionId);
		AssemblaRequest request = new AssemblaRequest(uri, WikiPageVersion.class);
		return super.get(request, String.format("No Wiki Page Version for id %s and version id %s", id, versionId));
	}

}
