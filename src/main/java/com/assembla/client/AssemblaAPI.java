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
import com.assembla.service.SSHServerResource;
import com.assembla.service.SSHServerService;
import com.assembla.service.SpaceResource;
import com.assembla.service.SpaceSSHKeyResource;
import com.assembla.service.SpaceSSHKeyService;
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

/**
 * Base class for accessing Assembla's REST API
 * 
 * @see <a href="https://api-doc.assembla.com/content/api_reference.html">
 *      Assembla API Documentation</a>
 * 
 * @author matthewsladen
 *
 */
public final class AssemblaAPI {

	private final AssemblaClient assemblaClient;

	AssemblaAPI(String apiKey, String apiSecret, AssemblaClient client) {
		this.assemblaClient = client;
	}

	/**
	 * Create a new AssemblaAPI object.
	 * 
	 * @param apiKey
	 *            User's Assembla API key
	 * @param apiSecret
	 *            Users Assembla API key secret
	 * @return A new AssemblaAPI which will use the supplied {@code apiKey} and
	 *         {@code apiSecret} to make requests
	 * 
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/authentication.html#key_secret_credentials">
	 *      Assembla Documentation for getting an API key</a>
	 */
	public static AssemblaAPI create(String apiKey, String apiSecret) {
		ValidationUtils.notNull(apiKey, "API Key Required");
		ValidationUtils.notNull(apiSecret, "API Secret Required");
		AssemblaClient client = new AssemblaClient(apiKey, apiSecret);
		return new AssemblaAPI(apiKey, apiSecret, client);
	}

	/**
	 * Get resource for accessing ticket end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return Ticket end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#tickets">
	 *      Documentation for ticket end points</a>
	 * 
	 */
	public TicketResource tickets(String spaceId) {
		return new TicketService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing activity end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return Activity end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#activity">
	 *      Documentation for activity end points</a>
	 * 
	 */
	public ActivityResource activity(String spaceId) {
		return new ActivityService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing mentions end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return mentions end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#mentions">
	 *      Documentation for mentions end points</a>
	 * 
	 */
	public MentionResource mentions(String spaceId) {
		return new MentionService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing users end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return users end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#users">
	 *      Documentation for users end points</a>
	 * 
	 */
	public UserResource users(String spaceId) {
		return new UserService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing spaces end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return spaces end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#spaces">
	 *      Documentation for spaces end points</a>
	 * 
	 */
	public SpaceResource spaces(String spaceId) {
		return new SpaceService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing user roles end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return user roles end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#user-roles-space-members">
	 *      Documentation for user roles end points</a>
	 * 
	 */
	public UserRoleResource roles(String spaceId) {
		return new UserRoleService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing space tools end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return space tools end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#space-tools">
	 *      Documentation for space tools end points</a>
	 * 
	 */
	public SpaceToolResource tools(String spaceId) {
		return new SpaceToolService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing ticket statuses end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return ticket statuses end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ticket-statuses">
	 *      Documentation for ticket statuses end points</a>
	 * 
	 */
	public TicketStatusResource ticketStatuses(String spaceId) {
		return new TicketStatusService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing tags end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return tags end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#tags">
	 *      Documentation for tags end points</a>
	 * 
	 */
	public TagResource tags(String spaceId) {
		return new TagService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing ticket custom fields end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return ticket custom fields end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#tickets-custom-fields">
	 *      Documentation for ticket custom fields end points</a>
	 * 
	 */
	public CustomFieldResource customFields(String spaceId) {
		return new CustomFieldService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing ticket associations end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return ticket associations end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ticket-associations">
	 *      Documentation for ticket associations end points</a>
	 * 
	 */
	public TicketAssociationResource ticketAssociations(String spaceId) {
		return new TicketAssociationService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing ticket comments end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return ticket comments end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ticket-comments">
	 *      Documentation for ticket comments end points</a>
	 * 
	 */
	public TicketCommentResource ticketComments(String spaceId) {
		return new TicketCommentService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing milestones end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return milestones end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#milestones">
	 *      Documentation for milestones end points</a>
	 * 
	 */
	public MilestoneResource milestones(String spaceId) {
		return new MilestoneService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing document end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return document end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#documents">
	 *      Documentation for document end points</a>
	 * 
	 */
	public DocumentResource documents(String spaceId) {
		return new DocumentService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing stand up report end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return stand up report end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#standup-reports">
	 *      Document for stand up end points</a>
	 * 
	 */
	public StandupReportResource standUps(String spaceId) {
		return new StandupReportService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing stand up away report end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return stand up away report end point resource
	 * @see <a href=
	 *      "https://api-doc.assembla.com/content/api_reference.html#standup-away-reports"
	 *      > Documentation for stand up away reports<a>
	 * 
	 */
	public StandupAwayReportResource standUpsAway(String spaceId) {
		return new StandupAwayReportService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing merge request end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @param spaceToolId
	 *            space tool id or name
	 * @return merge request end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#merge-requests">
	 *      Documentation for merge request end points</a>
	 * 
	 */
	public MergeRequestResource mergeRequests(String spaceId, int spaceToolId) {
		return new MergeRequestService(assemblaClient, spaceId, spaceToolId);
	}

	/**
	 * Get resource for accessing merge request version end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @param spaceToolId
	 *            space tool id or name
	 * @return merge request version end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#merge-request-versions">
	 *      Documentation for merge request version end points</a>
	 * 
	 */
	public MergeRequestVersionResource mergeRequestVersions(String spaceId, int spaceToolId) {
		return new MergeRequestVersionService(assemblaClient, spaceId, spaceToolId);
	}

	/**
	 * Get resource for accessing wiki page end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return wiki page end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#wiki-pages">
	 *      Documentation for wiki page end points</a>
	 * 
	 */
	public WikiPageResource wikis(String spaceId) {
		return new WikiService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing webhook end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return webhook end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#webhooks">
	 *      Documentation for webhook end points</a>
	 * 
	 */
	public WebhookResource webhooks(String spaceId) {
		return new WebhookService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing tasks end points
	 * 
	 * @return tasks end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#tasks">
	 *      Documentation for tasks end points</a>
	 * 
	 */
	public TaskResource tasks() {
		return new TaskService(assemblaClient);
	}

	/**
	 * Get resource for accessing user SSH key end points
	 * 
	 * @return user SSH key end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#user-ssh-keys">
	 *      Documentation for user SSH key end points</a>
	 * 
	 */
	public SSHKeyResource userKeys() {
		return new SSHKeyService(assemblaClient);
	}

	/**
	 * Get resource for accessing SSH action end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return SSH action end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ssh-actions">
	 *      Documentation for SSH action end points</a>
	 * 
	 */
	public SSHActionResource sshActions(String spaceId) {
		return new SSHActionService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing SSH action launch end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return SSH action launch end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ssh-action-launches">
	 *      Documentation for SSH action launch end points</a>
	 * 
	 */
	public SSHActionLaunchResource sshActionLaunches(String spaceId) {
		return new SSHActionLaunchService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing SSH server end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return SSH server end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#ssh-servers">
	 *      Documentation for SSH server end points</a>
	 * 
	 */
	public SSHServerResource sshServers(String spaceId) {
		return new SSHServerService(assemblaClient, spaceId);
	}

	/**
	 * Get resource for accessing space SSH key end points
	 * 
	 * @param spaceId
	 *            Id of the space for which requests will be made to
	 * @return space SSH key end point resource
	 * @see <a
	 *      href="https://api-doc.assembla.com/content/api_reference.html#space-ssh-keys">
	 *      Documentation for space SSH key end points</a>
	 * 
	 */
	public SpaceSSHKeyResource spaceKeys(String spaceId) {
		return new SpaceSSHKeyService(assemblaClient, spaceId);
	}

}
