package com.assembla.client;

public interface AssemblaConstants {

	/**
	 * API URI
	 */
	String HOST_API = "api.assembla.com";
	/**
	 * API URL
	 */
	String PROTOCOL = "https";
	/**
	 * API Version
	 */
	String VERSON_PREFIX = "/v1";
	/*
	 * HTTP Header for API Key
	 */
	String HEADER_API_KEY = "X-Api-Key";
	/*
	 * HTTP Header for API Secret Key
	 */
	String HEADER_API_SECRET = "X-Api-Secret";
	/*
	 * HTTP Header for User-Agent
	 */
	String HEADER_USER_AGENT = "User-Agent";
	/*
	 * User agent name
	 */
	String USER_AGENT = "AssemblaJavaApi/V1";
	/**
	 * Http Status for NO CONTENT response
	 */
	int NO_CONTENT = 204;
	/**
	 * API URL
	 */
	String URL = PROTOCOL + "://" + HOST_API + VERSON_PREFIX;
	/**
	 * API URL with a subdomain
	 */
	String URL_WITH_SUBDOMAIN = PROTOCOL + "://%s." + HOST_API + VERSON_PREFIX;
	/**
	 * Request parameter determining page number when making a request which
	 * returns paginated response
	 */
	String PAGE_PARAMETER = "page";
	/**
	 * Request parameter determining page size when making a request which
	 * returns paginated response
	 */
	String PAGE_SIZE_PARAMETER = "per_page";
	/**
	 * Default page number when making request which returns paginated results
	 */
	int DEFAULT_PAGE = 1;
	/**
	 * Default page size when making request which returns paginated results
	 */
	int DEFAULT_PAGE_SIZE = 25;
	/**
	 * File extension for JSON requests
	 */
	String FILE_EXTENSION = ".json";
	/**
	 * Media Type for JSON
	 */
	String JSON_MEDIA_TYPE = "application/json; charset=utf-8";
	/**
	 * URI for retrieving a ticket identified by an ID.
	 */
	String TICKET_BY_ID = "/spaces/%s/tickets/id/%s" + FILE_EXTENSION;
	/**
	 * URI for retrieving and modifying a a ticket identified by a ticket
	 * number.
	 */
	String TICKET_BY_NUMBER = "/spaces/%s/tickets/%d" + FILE_EXTENSION;
	/**
	 * URI for retreiving tickets by milestone
	 */
	String TICKETS_BY_NO_MILESTONE = "/spaces/%s/tickets/no_milestone" + FILE_EXTENSION;
	/**
	 * URI for retreiving full ticket list
	 */
	String TICKETS_BY_SPACE = "/spaces/%s/tickets" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of tickets user is following.
	 */
	String TICKETS_FOLLOWED = "/spaces/%s/tickets/my_followed" + FILE_EXTENSION;
	/**
	 * URI for retreiving a list of tickets assigned to current user.
	 */
	String TICKETS_BY_STATUS = "/spaces/%s/tickets/my_active" + FILE_EXTENSION;
	/**
	 * URI for retreiving tags associated with ticket
	 */
	String TAGS_FOR_TICKET = "/spaces/%s/tickets/%d/tags" + FILE_EXTENSION;
	/**
	 * URI for retreiving attachments associated with a ticket
	 */
	String ATTACHMENTS_FOR_TICKET = "/spaces/%s/tickets/%d/attachments" + FILE_EXTENSION;
	/**
	 * URI for retreiving a list of user and team reports available for the
	 * space.
	 */
	String TICKET_CUSTOM_REPORTS = "/spaces/%s/tickets/custom_reports" + FILE_EXTENSION;
	/**
	 * URI for deleting a ticket by number
	 */
	String TICKET_DELETE = "/spaces/%s/tickets/%d" + FILE_EXTENSION;
	/**
	 * URI for retrieving currently authenticated user.
	 */
	String USER_CURRENT = "/user" + FILE_EXTENSION;
	/**
	 * URI for retrieving a user by id or login
	 */
	String USER_ID_OR_LOGIN = "/users/%s" + FILE_EXTENSION;
	/**
	 * URI for retreiving users for a space
	 */
	String USERS_FOR_SPACE = "/spaces/%s/users" + FILE_EXTENSION;
	/**
	 * URI for user mentions
	 */
	String MENTIONS = "/user/mentions" + FILE_EXTENSION;
	/**
	 * URI for extensions by id
	 */
	String MENTION_BY_ID = "/user/mentions/%d" + FILE_EXTENSION;
	/**
	 * URI for marking a mention as read
	 */
	String MENTION_MARK_AS_READ = "/user/mention/%d/mark_as_read" + FILE_EXTENSION;
	/**
	 * URI for accessing and modifying ticket comments for a ticket
	 */
	String TICKET_COMMENTS_FOR_TICKET = "/spaces/%s/tickets/%d/ticket_comments" + FILE_EXTENSION;
	/**
	 * URI for getting a ticket's comment by id
	 */
	String TICKET_COMMENT = "/spaces/%s/tickets/%d/ticket_comments/%d" + FILE_EXTENSION;
	/**
	 * URI for returning list of spaces which current user is participating in.
	 */
	String SPACES = "/spaces" + FILE_EXTENSION;
	/**
	 * URI for returning a space by id or wiki name
	 */
	String SPACE_BY_ID = "/spaces/%s" + FILE_EXTENSION;
	/**
	 * URI for copying a space from a given template
	 */
	String SPACE_COPY = "/spaces/%s/copy" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of all tags.
	 */
	String TAGS = "/spaces/%s/tags" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of active tags
	 */
	String ACTIVE_TAGS = "/spaces/%s/tags/active" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of proposed tags
	 */
	String PROPOSED_TAGS = "/spaces/%s/tags/proposed" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of hidden tags
	 */
	String HIDDEN_TAGS = "/spaces/%s/tags/hidden" + FILE_EXTENSION;
	/**
	 * URI for retrieving a list of tickets associated with the tag.
	 */
	String TICKETS_BY_TAG = "/spaces/%s/tags/%d/tickets" + FILE_EXTENSION;
	/**
	 * URI for retrieving a tag by id
	 */
	String TAG_BY_ID = "/spaces/%s/tags/%d" + FILE_EXTENSION;
	/**
	 * URI for retrieving all upcoming milestones for a space
	 */
	String MILESTONE_UPCOMING = "/spaces/%s/milestones/upcoming" + FILE_EXTENSION;
	/**
	 * URI for retrieving all milestones for a space
	 */
	String MILESTONE_ALL = "/spaces/%s/milestones/all" + FILE_EXTENSION;
	/**
	 * URI for retrieving all complete milestones for a space
	 */
	String MILESTONE_COMPLETE = "/spaces/%s/milestones/completed" + FILE_EXTENSION;
	/**
	 * URI for retrieving all released milestones for a space
	 */
	String MILESTONE_RELEASE = "/spaces/%s/milestones/release_notes" + FILE_EXTENSION;
	/**
	 * URI for retrieving milestone by id
	 */
	String MILESTONE_BY_ID = "/spaces/%s/milestones/%s" + FILE_EXTENSION;
	/**
	 * URI for creating a milestone
	 */
	String MILESTONE = "/spaces/%s/milestones" + FILE_EXTENSION;
	/**
	 * URI for retrieving custom fields for a space
	 */
	String CUSTOM_FIELDS = "/spaces/%s/tickets/custom_fields" + FILE_EXTENSION;
	/**
	 * URI for retrieving custom fields by id
	 */
	String CUSTOM_FIELDS_BY_ID = "/spaces/%s/tickets/custom_fields/%d" + FILE_EXTENSION;
	/**
	 * URI for retrieving ticket associations by ticket number
	 */
	String TICKET_ASSOCIATIONS = "/spaces/%s/tickets/%d/ticket_associations" + FILE_EXTENSION;
	/*
	 * URI for retrieving ticket association for a ticket by id
	 */
	String TICKET_ASSOCIATIONS_BY_ID = "/spaces/%s/tickets/%d/ticket_associations/%d" + FILE_EXTENSION;
}
