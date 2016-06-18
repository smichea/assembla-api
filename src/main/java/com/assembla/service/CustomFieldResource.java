package com.assembla.service;

import java.util.List;

import com.assembla.CustomField;

public interface CustomFieldResource {

	List<CustomField> getAll();

	CustomField get(int id);

	CustomField create(CustomField customField);

	void update(CustomField customField);

	void delete(CustomField customField);

}
