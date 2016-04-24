package com.assembla.service;

import static java.lang.String.format;

import java.util.List;

import com.assembla.CustomField;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;

public class CustomFieldService extends AbstractBaseService {

	public CustomFieldService(AssemblaClient assemblaClient) {
		super(assemblaClient);
	}

	public List<CustomField> getAll() {
		String uri = format(AssemblaConstants.CUSTOM_FIELDS, client.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, CustomField[].class);
		return super.getList(request);
	}

	public CustomField get(int id) {
		String uri = format(AssemblaConstants.CUSTOM_FIELDS_BY_ID, client.getSpaceId(), id);
		AssemblaRequest request = new AssemblaRequest(uri, CustomField.class);
		return super.get(request, format("No custom field with id : %d exists", id));
	}

	public CustomField create(CustomField customField) {
		if(customField == null) {
			throw new IllegalArgumentException("customField == null");
		}
		String uri = format(AssemblaConstants.CUSTOM_FIELDS, client.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, CustomField.class);
		request.withBody(customField);
		return super.post(request);
	}

	public void update(CustomField customField) {
		if(customField == null || customField.getId() == null) {
			throw new IllegalArgumentException("customField == null || customField::getId == null");
		}
		String uri = format(AssemblaConstants.CUSTOM_FIELDS_BY_ID, client.getSpaceId(), customField.getId());
		AssemblaRequest request = new AssemblaRequest(uri, null);
		request.withBody(customField);
		client.doPut(request);
	}

	public void delete(CustomField customField) {
		if(customField == null || customField.getId() == null) {
			throw new IllegalArgumentException("customField == null || customField::getId == null");
		}
		String uri = format(AssemblaConstants.CUSTOM_FIELDS_BY_ID, client.getSpaceId(), customField.getId());
		AssemblaRequest request = new AssemblaRequest(uri, null);
		client.doDelete(request);
	}

}
