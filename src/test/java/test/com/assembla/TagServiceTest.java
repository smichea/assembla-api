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
import com.assembla.service.TagResource;
import com.assembla.service.TagService;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest extends ServiceTest {

	private TagResource tagService;

	@Before
	public void setup() {
		tagService = new TagService(super.assemblaClient, TEST_SPACE_ID);
	}
	
	@Test
	public void getTagsTest() {
		 when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Tag[10], Tag[].class));
		 PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags.json", Tag[].class);
		 PagedIterator<Tag> tags = tagService.getAll();
		 assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		 assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getActiveTagsTest() {
		 when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Tag[10], Tag[].class));
		 PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/active.json", Tag[].class);
		 PagedIterator<Tag> tags = tagService.getActive();
		 assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		 assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getProposedTagsTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/proposed.json", Tag[].class);
		PagedIterator<Tag> tags = tagService.getProposed();
		assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getHiddenTagsTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/hidden.json", Tag[].class);
		PagedIterator<Tag> tags = tagService.getHidden();
		assertEquals("Tag should have a request equal to request", request, tags.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tags.hasNext());
	}
	
	@Test
	public void getTicketsForTag() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag[10], Tag[].class));
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tags/100/tickets.json", Tag[].class);
		
		Tag tag = new Tag();
		tag.setId(100);
		
		PagedIterator<Ticket> tickets = tagService.getTickets(tag);
		
		assertEquals("Tag should have a request equal to request", request, tickets.getRequest());
		assertTrue("Tags iterator hasn't been called so should haveNext()", tickets.hasNext());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getTicketsForTagNullArgTest() {
		tagService.getTickets(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getTicketsForTagNoIdTest() {
		tagService.getTickets(new Tag());
	}
	
	@Test
	public void getTagByIdTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag(), Tag.class));
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json", Tag.class);
		Tag tag = tagService.get(100);
		verify(assemblaClient).get(request);
		assertNotNull(tag);
	}
	
	@Test
	public void createTagTest() {
		when(assemblaClient.post(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new Tag(), Tag.class));
		
		Tag tag = new Tag();
		tag.setName("Test Tag name");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags.json", Tag.class);
		request.withBody(tag);
		
		Tag newTag = tagService.create(tag);
		
		verify(assemblaClient).post(request);
		assertNotNull(newTag);
	}
	
	@Test
	public void createTagFailedTest() {
		when(assemblaClient.post(any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException("Failed"));
		Tag tag = new Tag();
		tag.setName("Test Tag name");
		Tag newTag = tagService.create(tag);
		assertNull(newTag);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createTagTestNullArg() {
		tagService.create(null);
	}
	
	@Test
	public void updateTagTest() {
		when(assemblaClient.put(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(Tag.class));
		
		Tag tag  = new Tag();
		tag.setId(100);;
		tag.setName("Test");
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json");
		request.withBody(tag);
	
		tagService.update(tag);
		verify(assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateTagNullArgTest() {
		tagService.update(null);
	}
	
	@Test
	public void deleteTagTest() {
		when(assemblaClient.delete(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(Tag.class));
		
		Tag tag  = new Tag();
		tag.setId(100);;
		tag.setName("Test");
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tags/100.json");
	
		tagService.delete(tag);
		
		verify(assemblaClient).delete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteTagNullArgTest() {
		tagService.delete(null);
	}
	
}
