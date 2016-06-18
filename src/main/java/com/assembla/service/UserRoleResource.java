package com.assembla.service;

import java.util.List;

import com.assembla.UserRole;

public interface UserRoleResource {

	List<UserRole> getAll();

	UserRole get(long id);

	UserRole create(UserRole role);

	void update(UserRole role);

	void delete(UserRole role);

}
