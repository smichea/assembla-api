package com.assembla.service;

import java.util.List;

import com.assembla.Space;

public interface SpaceResource {

	List<Space> getAll();

	Space get(String id);

	Space create(Space space);

	void update(Space space);

	void delete(Space space);

	Space copy(Space oldSpace, String name, String wikiName);

}
