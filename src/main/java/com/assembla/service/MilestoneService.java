package com.assembla.service;

import static java.lang.String.format;
import com.assembla.Milestone;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.utils.ObjectUtils;

public class MilestoneService extends AbstractBaseService {

	public MilestoneService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public PagedIterator<Milestone> getUpcoming() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(format(AssemblaConstants.MILESTONE_UPCOMING,
				super.getSpaceId()), Milestone[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Milestone> getAll() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(format(AssemblaConstants.MILESTONE_ALL, super.getSpaceId()),
				Milestone[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Milestone> getCompleted() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(format(AssemblaConstants.MILESTONE_COMPLETE,
				super.getSpaceId()), Milestone[].class);
		return new PagedIterator<>(request, client);
	}

	public PagedIterator<Milestone> getReleases() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(format(AssemblaConstants.MILESTONE_RELEASE,
				super.getSpaceId()), Milestone[].class);
		return new PagedIterator<>(request, client);
	}

	public Milestone get(String milestoneId) {
		ObjectUtils.notNull(milestoneId, "milestoneId == null");
		String uri = format(AssemblaConstants.MILESTONE_BY_ID, super.getSpaceId(), milestoneId);
		AssemblaRequest request = new AssemblaRequest(uri, Milestone.class);
		return super.get(request, format("Milestone with id %s does not exist", milestoneId));
	}

	public Milestone create(Milestone milestoneToCreate) {
		AssemblaRequest request = new AssemblaRequest(format(AssemblaConstants.MILESTONE, super.getSpaceId()),
				Milestone.class);
		request.withBody(milestoneToCreate);
		return super.post(request);
	}

	public void update(Milestone milestone) {
		ObjectUtils.notNull(milestone, "milestone == null");
		ObjectUtils.notNull(milestone, "milestone requires a id");
		
		AssemblaRequest request = new AssemblaRequest(format(AssemblaConstants.MILESTONE_BY_ID, super.getSpaceId(),
				milestone.getId()), Milestone.class);
		request.withBody(milestone);
		client.doPut(request);
	}

	public void delete(Milestone milestone) {
		ObjectUtils.notNull(milestone, "milestone == null");
		ObjectUtils.notNull(milestone, "milestone requires a id");
		
		AssemblaRequest request = new AssemblaRequest(format(AssemblaConstants.MILESTONE_BY_ID, super.getSpaceId(),
				milestone.getId()), Milestone.class);
		request.withBody(milestone);
		client.doDelete(request);
	}

}
