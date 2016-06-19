package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.client.AssemblaAPI;
import com.assembla.client.AssemblaResource;
import com.assembla.service.ActivityResource;
import com.assembla.service.CustomFieldResource;
import com.assembla.service.DocumentResource;
import com.assembla.service.MentionResource;
import com.assembla.service.MergeRequestResource;
import com.assembla.service.MergeRequestVersionResource;
import com.assembla.service.MilestoneResource;
import com.assembla.service.SSHActionLaunchResource;
import com.assembla.service.SSHActionResource;
import com.assembla.service.SSHKeyResource;
import com.assembla.service.SSHServerResource;
import com.assembla.service.SpaceResource;
import com.assembla.service.SpaceSSHKeyResource;
import com.assembla.service.SpaceToolResource;
import com.assembla.service.StandupAwayReportResource;
import com.assembla.service.StandupReportResource;
import com.assembla.service.TagResource;
import com.assembla.service.TaskResource;
import com.assembla.service.TicketAssociationResource;
import com.assembla.service.TicketCommentResource;
import com.assembla.service.TicketResource;
import com.assembla.service.TicketStatusResource;
import com.assembla.service.UserResource;
import com.assembla.service.UserRoleResource;
import com.assembla.service.WebhookResource;
import com.assembla.service.WikiPageResource;

public class AssemblaAPITest {

	@Test
	public void createAssemblaAPI() {
		AssemblaResource api = AssemblaAPI.create("key", "secret");
		assertNotNull(api);
	}

	@Test(expected = IllegalArgumentException.class)
	public void assemblaClientRequiresKey() {
		AssemblaAPI.create(null, "secret");
	}

	@Test(expected = IllegalArgumentException.class)
	public void assemblaClientRequiresApiSecret() {
		AssemblaAPI.create("test", null);
	}
	
	@Test
	public void allResourcesExist() {
		AssemblaResource api = AssemblaAPI.create("key", "secret");
		
		TicketResource ticket = api.tickets("space_id");
		assertNotNull(ticket);
		
		ActivityResource activity = api.activity("space_id");
		assertNotNull(activity);
		
		MentionResource mention = api.mentions("space_id");
		assertNotNull(mention);
		
		UserResource users = api.users("space_id");
		assertNotNull(users);
		
		SpaceResource spaces = api.spaces("space_id");
		assertNotNull(spaces);

		UserRoleResource userRoles = api.roles("space_id");
		assertNotNull(userRoles);
		
		SpaceToolResource tools = api.tools("space_id");
		assertNotNull(tools);
		
		TicketStatusResource ticketStatues = api.ticketStatuses("space_id");
		assertNotNull(ticketStatues);
		
		TagResource tags = api.tags("space_id");
		assertNotNull(tags);
		
		CustomFieldResource customFields = api.customFields("space_id");
		assertNotNull(customFields);
		
		TicketAssociationResource associations = api.ticketAssociations("space_id");
		assertNotNull(associations);
		
		TicketCommentResource comments = api.ticketComments("space_id");
		assertNotNull(comments);
		
		MilestoneResource milestones = api.milestones("space_id");
		assertNotNull(milestones);	
		
		DocumentResource documents = api.documents("space_id");
		assertNotNull(documents);
		
		StandupReportResource standup = api.standUps("space_id");
		assertNotNull(standup);
		
		StandupAwayReportResource standupaway = api.standUpsAway("space_id");
		assertNotNull(standupaway);

		MergeRequestResource merge = api.mergeRequests("space_id", 12);
		assertNotNull(merge);
		
		MergeRequestVersionResource mergeVersions = api.mergeRequestVersions("space_id", 12);
		assertNotNull(mergeVersions);
		
		WikiPageResource wikis = api.wikis("space_id");
		assertNotNull(wikis);
		
		WebhookResource hooks = api.webhooks("space_id");
		assertNotNull(hooks);
		
		TaskResource tasks = api.tasks();
		assertNotNull(tasks);
		
		SSHKeyResource sshkeys = api.userKeys();
		assertNotNull(sshkeys);
		
		SSHActionResource sshActions = api.sshActions("space_id");
		assertNotNull(sshActions);
		
		SSHActionLaunchResource sshActionLaunches = api.sshActionLaunches("space_id");
		assertNotNull(sshActionLaunches);
		
		SSHServerResource sshServers = api.sshServers("space_id");
		assertNotNull(sshServers);
		
		SpaceSSHKeyResource spaceKeys = api.spaceKeys("space_id");
		assertNotNull(spaceKeys);
	}
	
}