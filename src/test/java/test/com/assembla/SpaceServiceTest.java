package test.com.assembla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Space;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SpaceResource;
import com.assembla.service.SpaceService;

@RunWith(MockitoJUnitRunner.class)
public class SpaceServiceTest extends ServiceTest {

	private SpaceResource spaceService;

	@Before
	public void setup() {
		spaceService = new SpaceService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getSpacesTest() {
		 when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Space[10], Space[].class));
		//Given a request to get all spaces
		AssemblaRequest request = new AssemblaRequest("/spaces.json", Space[].class);
		List<Space> spaces = spaceService.getAll();
		//When we make the request
		verify(assemblaClient).get(request);
		//Then it looks as per example request 
		assertNotNull(spaces);
		assertEquals("List of spaces is not the correct length" , 10, spaces.size());
	}
	
	@Test
	public void getSpacesNoneReturnedTest() {
		//Given request to get all spaces which will return no spaces
		 when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(null, Space[].class));
		 
		AssemblaRequest request = new AssemblaRequest("/spaces.json", Space[].class);
		//When we make the request
		List<Space> spaces = spaceService.getAll();
		
		//Then the request performed is per example request and the result is an empty list
		verify(assemblaClient).get(request);
		assertNotNull(spaces);
		assertEquals("List of spaces is not the correct length" , 0, spaces.size());
	}
	
	@Test
	public void getSpaceByIdOrNameTest() {
		 when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(
		 new AssemblaResponse(new Space(), Space.class));
		//Given request to get a space with id 123 which exists
		AssemblaRequest request = new AssemblaRequest("/spaces/123.json", Space.class);
		
		//When we make the request
		Space space = spaceService.get("123");
		
		//Then it looks like example request and is not null
		assertNotNull(space);
		verify(assemblaClient).get(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getSpaceByIdOrNameNoParamTest() {
		spaceService.get(null);
	}
	
	@Test
	public void createSpaceTest() {
		// Given a successful request to create a new space
		Space value = new Space();
		when(assemblaClient.post(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(value, Space.class));

		Space space = new Space();
		AssemblaRequest request = new AssemblaRequest("/spaces.json", Space.class);
		request.withBody(space);
		// When we make the request
		Space newSpace = spaceService.create(space);
		// Then the request should look like the sample and return a space
		assertNotNull(newSpace);
		verify(assemblaClient).post((request));
	}
	
	@Test
	public void updateSpaceTest() {
		when(assemblaClient.put(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(Space.class));
		Space space = new Space();
		space.setId("100");
		AssemblaRequest request = new AssemblaRequest("/spaces/100.json", Space.class);
		request.withBody(space);
		
		spaceService.update(space);
		verify(assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateSpaceNullArgTest() {
		spaceService.update(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void updateSpaceNoIdTest() {
		spaceService.update(new Space());
	}
	
	@Test
	public void deleteSpaceTest() {
		when(assemblaClient.delete(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		Space space = new Space();
		space.setId("100");
		AssemblaRequest request = new AssemblaRequest("/spaces/100.json");
		spaceService.delete(space);
		verify(assemblaClient).delete(request);
	}

	@Test(expected=IllegalArgumentException.class)
	public void deleteSpaceNullArg() {
		spaceService.delete(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void deleteSpaceNullid() {
		spaceService.delete(new Space());
	}
	
	@Test
	public void createSpaceFromTemplateTest() {
		Space value = new Space();
		when(assemblaClient.post(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(value, Space.class));

		Space oldSpace = new Space();
		oldSpace.setId("100");
		
		// When we make the request
		Space newSpace = spaceService.copy(oldSpace, "test name", "test wiki name");
		// Then the request should look like the sample and return a space
		assertNotNull(newSpace);
		
		ArgumentCaptor<AssemblaRequest> captor = ArgumentCaptor.forClass(AssemblaRequest.class);
		verify(assemblaClient).post((captor.capture()));
		
		Space space = (Space) captor.getValue().getBody().get();
		assertEquals("test name", space.getName());
		assertEquals("test wiki name", space.getWikiName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createSpaceFromTemplateNoSpaceTest() {
		spaceService.copy(null, "test name", "test wiki name");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createSpaceFromTemplateNoNameTest() {
		spaceService.copy(new Space(), null, "test wiki name");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createSpaceFromTemplateNoWikiTest() {
		spaceService.copy(new Space(), "test name", null);
	}
}
