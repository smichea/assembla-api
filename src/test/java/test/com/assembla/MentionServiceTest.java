package test.com.assembla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Mention;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.MentionService;

@RunWith(MockitoJUnitRunner.class)
public class MentionServiceTest extends ServiceTest {

	private MentionService mentionService;

	@Before
	public void setup() {
		mentionService = new MentionService(super.assemblaClient, TEST_SPACE_ID);
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Mention[10], Mention[].class));
	}

	@Test
	public void getAllUserMentionsTest() {
		// Given request to get all user mentions
		AssemblaRequest request = new AssemblaRequest("/user/mentions.json", Mention[].class);
		// When we make the request
		List<Mention> mentions = mentionService.getAll();
		// Then we expect request to be same as this
		verify(assemblaClient).get(request);
		assertNotNull(mentions);
	}

	@Test
	public void getAllUserMentionsNoneTest() {
		// Given a user with no mentions, when we request all mentions then we
		// get empty list
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(Mention[].class));
		List<Mention> mentions = mentionService.getAll();
		assertEquals("Mentions not an empty list", Collections.emptyList(), mentions);
	}

	@Test
	public void getAllUserMentionsReadTest() {
		// Given request to get all user mentions
		AssemblaRequest request = new AssemblaRequest("/user/mentions.json?read=true", Mention[].class);
		// When we make the request
		List<Mention> mentions = mentionService.getAllRead();
		// Then we expect request to be same as this
		verify(assemblaClient).get(request);
		assertNotNull(mentions);
	}

	@Test
	public void getAllUserMentionsUnReadTest() {
		// Given request to get all user mentions
		AssemblaRequest request = new AssemblaRequest("/user/mentions.json?unread=true", Mention[].class);
		// When we make the request
		List<Mention> mentions = mentionService.getAllUnread();
		// Then we expect request to be same as this
		verify(assemblaClient).get(request);
		assertNotNull(mentions);
	}

	@Test
	public void getMentionByIdTest() {
		when(assemblaClient.get(any(AssemblaRequest.class)))
				.thenReturn(new AssemblaResponse(new Mention(), Mention.class));
		AssemblaRequest request = new AssemblaRequest("/user/mentions/100.json", Mention.class);
		// When we make the request
		int id = 100;
		Mention mentions = mentionService.getMention(id);
		// Then we expect request to be same as this
		verify(assemblaClient).get(request);
		assertNotNull(mentions);
	}

	@Test(expected = AssemblaAPIException.class)
	public void getMentionByIdNoneTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(Mention.class));
		mentionService.getMention(100);
	}

	@Test
	public void markAsReadTest() {
		// Given request to read a mention
		AssemblaRequest request = new AssemblaRequest("/user/mention/100/mark_as_read.json");
		// When we make the request
		mentionService.markAsRead(100);
		// Then we expect request to be same as this
		verify(assemblaClient).put(request);
	}

}
