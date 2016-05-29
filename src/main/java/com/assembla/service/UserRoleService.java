package com.assembla.service;

import java.util.List;

import static java.lang.String.format;

import com.assembla.UserRole;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;
import com.assembla.utils.ValidationUtils;

public class UserRoleService extends AbstractBaseService {

	public UserRoleService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public List<UserRole> getAll() {
		String uri = format(AssemblaConstants.USER_ROLES_ALL, super.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, UserRole[].class);
		return super.getList(request);
	}

	public UserRole get(long id) {
		String uri = format(AssemblaConstants.USER_ROLES_ID, super.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri, UserRole.class);
		return super.get(request, format("No UserRole with id : %d", id));
	}

	public UserRole create(UserRole role) {
		ValidationUtils.notNull(role, "UserRole == null");
		String uri = format(AssemblaConstants.USER_ROLES_ALL, super.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, UserRole.class);
		request.withBody(role);
		return super.post(request);
	}

	public void update(UserRole role) {
		ValidationUtils.notNull(role, "UserRole == null");
		ValidationUtils.notNull(role.getId(), "UserRole must have an Id");
		String uri = format(AssemblaConstants.USER_ROLES_ID, super.spaceId, role.getId());
		AssemblaRequest request = new AssemblaRequest(uri, UserRole.class);
		request.withBody(role);
		super.client.put(request);
	}

	public void delete(UserRole role) {
		ValidationUtils.notNull(role, "UserRole == null");
		ValidationUtils.notNull(role.getId(), "UserRole must have an Id");
		String uri = format(AssemblaConstants.USER_ROLES_ID, super.spaceId, role.getId());
		AssemblaRequest request = new AssemblaRequest(uri, UserRole.class);
		super.client.delete(request);
	}

}
