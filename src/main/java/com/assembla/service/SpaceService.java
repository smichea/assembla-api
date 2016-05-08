package com.assembla.service;

import static java.lang.String.format;

import java.util.List;

import com.assembla.Space;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.utils.ObjectUtils;

public class SpaceService extends AbstractBaseService {

	public SpaceService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public List<Space> getSpaces() {
		AssemblaRequest request = new AssemblaRequest(AssemblaConstants.SPACES, Space[].class);
		return super.getList(request);
	}

	public Space getSpace(String id) {
		ObjectUtils.notNull(id, "id == null");
		AssemblaRequest request = new AssemblaRequest(format(AssemblaConstants.SPACE_BY_ID, id), Space.class);
		return super.get(request, format("Space with id %s does not exist", id));
	}

	public Space createSpace(Space space) {
		AssemblaRequest request = new AssemblaRequest(AssemblaConstants.SPACES, Space.class);
		request.withBody(space);
		return super.post(request);
	}

	public void updateSpace(Space space) {
		ObjectUtils.notNull(space, "space == null");
		ObjectUtils.notNull(space.getId(), "space requires an id");

		String uri = format(AssemblaConstants.SPACE_BY_ID, space.getId());
		AssemblaRequest request = new AssemblaRequest(uri, Space.class);
		request.withBody(space);
		super.client.doPut(request);
	}

	public void deleteSpace(Space space) {
		ObjectUtils.notNull(space, "space == null");
		ObjectUtils.notNull(space.getId(), "space requires an id");
		
		String uri = format(AssemblaConstants.SPACE_BY_ID, space.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		client.doDelete(request);
	}

	public Space copySpace(Space oldSpace, String name, String wikiName) {
		ObjectUtils.notNull(oldSpace, "oldSpace == null");
		ObjectUtils.notNull(name, "name must not be null");
		ObjectUtils.notNull(wikiName, "wikiName must not be null");
		
		String uri = format(AssemblaConstants.SPACE_COPY, oldSpace.getId());
		AssemblaRequest request = new AssemblaRequest(uri, Space.class);
		//Template for serializing
		Space space = new Space();
		space.setName(name);
		space.setWikiName(wikiName);
		request.withBody(space);
		
		return super.post(request);
	}

}
