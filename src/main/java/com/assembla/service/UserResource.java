package com.assembla.service;

import java.util.List;

import com.assembla.User;

public interface UserResource {

	User get();

	User get(String idOrLogin);

	List<User> getForSpace();

}
