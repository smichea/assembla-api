package com.assembla.service;

import java.util.List;

import static java.lang.String.format;

import com.assembla.SpaceTool;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.utils.ObjectUtils;

public class SpaceToolService extends AbstractBaseService {

	public SpaceToolService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public List<SpaceTool> getAll() {
		String uri = format(AssemblaConstants.SPACE_TOOLS, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, SpaceTool[].class);
		return super.getList(request);
	}

	public List<SpaceTool> getRepositories() {
		String uri = format(AssemblaConstants.SPACE_TOOLS_REPOS, super.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, SpaceTool[].class);
		return super.getList(request);
	}

	public SpaceTool get(String idOrName) {
		ObjectUtils.notNull(idOrName, "idOrName == null");
		String uri = format(AssemblaConstants.SPACE_TOOLS_ID, super.getSpaceId(), idOrName);
		AssemblaRequest request = new AssemblaRequest(uri, SpaceTool.class);
		return super.get(request, format("No SpaceTool with id or name : %s", idOrName));
	}

	public SpaceTool create(SpaceTool tool) {
		ObjectUtils.notNull(tool, "tool == null");
		ObjectUtils.notNull(tool.getToolId(), "Tool id required to add a new tool");
		String uri = format(AssemblaConstants.SPACE_TOOLS_ADD, super.getSpaceId(), tool.getToolId());
		AssemblaRequest request = new AssemblaRequest(uri, SpaceTool.class);
		request.withBody(tool);
		return super.post(request);
	}

	public void update(SpaceTool tool) {
		ObjectUtils.notNull(tool, "tool == null");
		String id = getId(tool);
		ObjectUtils.notNull(id, "id or name must be present to update space tool");
		String uri = format(AssemblaConstants.SPACE_TOOLS_ID, super.getSpaceId(), id);
		AssemblaRequest request = new AssemblaRequest(uri, SpaceTool.class);
		request.withBody(tool);
		super.getClient().doPut(request);
	}

	public void delete(SpaceTool tool) {
		ObjectUtils.notNull(tool, "tool == null");
		String id = getId(tool);
		ObjectUtils.notNull(id, "id or name must be present to delete space tool");
		String uri = format(AssemblaConstants.SPACE_TOOLS_ID, super.getSpaceId(), id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.getClient().doDelete(request);
	}

	private String getId(SpaceTool tool) {
		String id = tool.getId();
		if (id == null) {
			id = tool.getName();
		}
		return id;
	}
}
