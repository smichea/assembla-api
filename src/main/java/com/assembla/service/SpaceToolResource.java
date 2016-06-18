package com.assembla.service;

import java.util.List;

import com.assembla.SpaceTool;

public interface SpaceToolResource {

	List<SpaceTool> getAll();

	List<SpaceTool> getRepositories();

	SpaceTool get(String idOrName);

	SpaceTool create(SpaceTool tool);

	void update(SpaceTool tool);

	void delete(SpaceTool tool);

}
