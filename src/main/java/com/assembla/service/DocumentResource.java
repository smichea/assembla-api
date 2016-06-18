package com.assembla.service;

import java.io.File;

import com.assembla.Document;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;

public interface DocumentResource {

	PagedIterator<Document> getAll(Paging paging);

	Document get(String id);

	Document create(File file, String location);

	void update(Document document);

	Document update(String id, File file, String location);

	void delete(String id);

}
