package test.com.assembla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.TagService;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest extends ServiceTest {

	private TagService tagService;

	@Before
	public void setup() {
		tagService = new TagService(super.assemblaClient, TEST_SPACE_ID);
	}
	
	@Test
	public void getTagsTest() {
		 when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Tag[10], Tag[].class));
		 PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags.json", Tag[].class);
		 PagedIterator<Tag> tags = tagService.getTags();
		 assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		 assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getActiveTagsTest() {
		 when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Tag[10], Tag[].class));
		 PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/active.json", Tag[].class);
		 PagedIterator<Tag> tags = tagService.getActiveTags();
		 assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		 assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getProposedTagsTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/proposed.json", Tag[].class);
		PagedIterator<Tag> tags = tagService.getProposedTags();
		assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getHiddenTagsTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/hidden.json", Tag[].class);
		PagedIterator<Tag> tags = tagService.getHiddenTags();
		assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getTicketsForTag() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/100/tickets.json", Tag[].class);
		
		Tag tag = new Tag();
		tag.setId(100);
		
		PagedIterator<Ticket> tickets = tagService.getTicketsForTag(tag);
		
		assertEquals("Tag should have a request equal to request", request, tickets.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tickets.hasNext());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getTicketsForTagNullArgTest() {
		tagService.getTicketsForTag(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getTicketsForTagNoIdTest() {
		tagService.getTicketsForTag(new Tag());
	}
	
	@Test
	public void getTagByIdTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag(), Tag.class));
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json", Tag.class);
		Tag tag = tagService.getTag(100);
		verify(assemblaClient).doGet(request);
		assertNotNull(tag);
	}
	
	@Test
	public void createTagTest() {
		when(assemblaClient.doPost(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag(), Tag.class));
		
		Tag tag = new Tag();
		tag.setName("Test Tag name");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags.json", Tag.class);
		request.withBody(tag);
		
		Tag newTag = tagService.createTag(tag);
		
		verify(assemblaClient).doPost(request);
		assertNotNull(newTag);
	}
	
	@Test
	public void createTagFailedTest() {
		when(assemblaClient.doPost(any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException("Failed"));
		Tag tag = new Tag();
		tag.setName("Test Tag name");
		Tag newTag = tagService.createTag(tag);
		assertNull(newTag);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createTagTestNullArg() {
		tagService.createTag(null);
	}
	
	@Test
	public void updateTagTest() {
		when(assemblaClient.doPut(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(null, Tag.class));
		
		Tag tag  = new Tag();
		tag.setId(100);;
		tag.setName("Test");
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json");
		request.withBody(tag);
	
		tagService.updateTag(tag);
		verify(assemblaClient).doPut(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateTagNullArgTest() {
		tagService.updateTag(null);
	}
	
	@Test
	public void deleteTagTest() {
		when(assemblaClient.doDelete(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(null, Tag.class));
		
		Tag tag  = new Tag();
		tag.setId(100);;
		tag.setName("Test");
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json");
	
		tagService.deleteTag(tag);
		
		verify(assemblaClient).doDelete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteTagNullArgTest() {
		tagService.deleteTag(null);
	}
	
}
