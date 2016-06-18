package com.assembla.client;

import test.com.assembla.TaskResource;
import test.com.assembla.TaskService;

import com.assembla.service.ActivityResource;
import com.assembla.service.ActivityService;
import com.assembla.service.CustomFieldResource;
import com.assembla.service.CustomFieldService;
import com.assembla.service.DocumentResource;
import com.assembla.service.DocumentService;
import com.assembla.service.MentionResource;
import com.assembla.service.MentionService;
import com.assembla.service.MergeRequestResource;
import com.assembla.service.MergeRequestService;
import com.assembla.service.MergeRequestVersionResource;
import com.assembla.service.MergeRequestVersionService;
import com.assembla.service.MilestoneResource;
import com.assembla.service.MilestoneService;
import com.assembla.service.SSHActionLaunchResource;
import com.assembla.service.SSHActionLaunchService;
import com.assembla.service.SSHActionResource;
import com.assembla.service.SSHActionService;
import com.assembla.service.SSHKeyResource;
import com.assembla.service.SSHKeyService;
import com.assembla.service.SpaceResource;
import com.assembla.service.SpaceService;
import com.assembla.service.SpaceToolResource;
import com.assembla.service.SpaceToolService;
import com.assembla.service.StandupAwayReportResource;
import com.assembla.service.StandupAwayReportService;
import com.assembla.service.StandupReportResource;
import com.assembla.service.StandupReportService;
import com.assembla.service.TagResource;
import com.assembla.service.TagService;
import com.assembla.service.TicketAssociationResource;
import com.assembla.service.TicketAssociationService;
import com.assembla.service.TicketCommentResource;
import com.assembla.service.TicketCommentService;
import com.assembla.service.TicketResource;
import com.assembla.service.TicketService;
import com.assembla.service.TicketStatusResource;
import com.assembla.service.TicketStatusService;
import com.assembla.service.UserResource;
import com.assembla.service.UserRoleResource;
import com.assembla.service.UserRoleService;
import com.assembla.service.UserService;
import com.assembla.service.WebhookResource;
import com.assembla.service.WebhookService;
import com.assembla.service.WikiPageResource;
import com.assembla.service.WikiService;
import com.assembla.utils.ValidationUtils;

public class AssemblaAPI {

	private final AssemblaClient assemblaClient;

	AssemblaAPI(String apiKey, String apiSecret, AssemblaClient client) {
		this.assemblaClient = client;
	}

	public static AssemblaAPI create(String apiKey, String apiSecret) {
		ValidationUtils.notNull(apiKey, "API Key Required");
		ValidationUtils.notNull(apiSecret, "API Secret Required");
		AssemblaClient client = new AssemblaClient(apiKey, apiSecret);
		return new AssemblaAPI(apiKey, apiSecret, client);
	}

	public TicketResource tickets(String spaceId) {
		return new TicketService(assemblaClient, spaceId);
	}

	public ActivityResource activity(String spaceId) {
		return new ActivityService(assemblaClient, spaceId);
	}

	public MentionResource mentions(String spaceId) {
		return new MentionService(assemblaClient, spaceId);
	}

	public UserResource users(String spaceId) {
		return new UserService(assemblaClient, spaceId);
	}

	public SpaceResource spaces(String spaceId) {
		return new SpaceService(assemblaClient, spaceId);
	}

	public UserRoleResource roles(String spaceId) {
		return new UserRoleService(assemblaClient, spaceId);
	}

	public SpaceToolResource tools(String spaceId) {
		return new SpaceToolService(assemblaClient, spaceId);
	}

	public TicketStatusResource ticketStatuses(String spaceId) {
		return new TicketStatusService(assemblaClient, spaceId);
	}

	public TagResource tags(String spaceId) {
		return new TagService(assemblaClient, spaceId);
	}

	public CustomFieldResource customFields(String spaceId) {
		return new CustomFieldService(assemblaClient, spaceId);
	}

	public TicketAssociationResource ticketAssociations(String spaceId) {
		return new TicketAssociationService(assemblaClient, spaceId);
	}

	public TicketCommentResource ticketComments(String spaceId) {
		return new TicketCommentService(assemblaClient, spaceId);
	}

	public MilestoneResource milestones(String spaceId) {
		return new MilestoneService(assemblaClient, spaceId);
	}

	public DocumentResource documents(String spaceId) {
		return new DocumentService(assemblaClient, spaceId);
	}

	public StandupReportResource standUps(String spaceId) {
		return new StandupReportService(assemblaClient, spaceId);
	}

	public StandupAwayReportResource standUpsAway(String spaceId) {
		return new StandupAwayReportService(assemblaClient, spaceId);
	}

	public MergeRequestResource mergeRequests(String spaceId, int spaceToolId) {
		return new MergeRequestService(assemblaClient, spaceId, spaceToolId);
	}

	public MergeRequestVersionResource mergeRequestVersions(String spaceId, int spaceToolId) {
		return new MergeRequestVersionService(assemblaClient, spaceId, spaceToolId);
	}

	public WikiPageResource wikis(String spaceId) {
		return new WikiService(assemblaClient, spaceId);
	}

	public WebhookResource webhooks(String spaceId) {
		return new WebhookService(assemblaClient, spaceId);
	}

	public TaskResource tasks() {
		return new TaskService(assemblaClient);
	}

	public SSHKeyResource keys() {
		return new SSHKeyService(assemblaClient);
	}

	public SSHActionResource sshActions(String spaceId) {
		return new SSHActionService(assemblaClient, spaceId);
	}

	public SSHActionLaunchResource sshActionLaunches(String spaceId) {
		return new SSHActionLaunchService(assemblaClient, spaceId);
	}

}
