package test.com.assembla;

//import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Document;
import com.assembla.Ticket;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.AssemblaClient;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.UploadAssemblaRequest;
import com.assembla.client.UploadableDocument;
import com.assembla.client.UploadableItem;

@RunWith(MockitoJUnitRunner.class)
public class AssemblaClientTest {

	@Mock
	private UploadableItem<Object> item;

	@Test
	public void testFullUrl() {
		assertEquals("Full url correct", "https://api.assembla.com/v1", AssemblaConstants.URL);
	}

	@Test
	public void testCreation() {
		//Given a new AssemblaClient 
		AssemblaClient client = new AssemblaClient("apiuser", "apipassword");
		//When we look at the object it's been initalised with the values we specified
		assertEquals("Username not equal to apiuser", "apiuser", client.getKey());
		assertEquals("Base url default value not correct" , AssemblaConstants.URL, client.getBaseURL());
	}


	@Test
	public void testCreatingAssemblaRequest() {
		//Given a new AssemblaRequest for a ticket to a specified URI with 2 request parameters
		AssemblaRequest request = new AssemblaRequest("uritest", Ticket.class);
		request.addParam("test", "test").addParam("test2", "test2");

		Map<String, Object> params = new HashMap<>();
		params.put("test", "test");
		params.put("test2", "test2");

		//When we look at the request it has been created with the values we specified
		assertEquals("Type of Ticket.class", Ticket.class, request.getType().get());
		assertEquals("URI is not equal to uritest", "uritest", request.getUri());
		assertEquals("Request params not equal", params, request.getParameters());
		// The url has parameters encoded
		String fullUri = "uritest?test=test&test2=test2";
		assertEquals("Full URI is correct with all parameters", fullUri, request.getFullURI());
	}
	
	@Test
	public void testCreatingAssemblaResponse() {
		//Given a new AssemblaResponse for a non null value
		Ticket ticket = new Ticket();
		AssemblaResponse response = new AssemblaResponse(ticket ,Ticket.class);
		//When we get the value which has been wrapped by this response, then it's an optional wrapped Ticket
		assertEquals(Ticket.class , response.getType().get());
		assertEquals(Optional.of(ticket), response.<Ticket>getValue());
	}
	
	@Test
	public void testNullAssemblaResponse() {
		//Given a new AssemblaResponse wrapping null
		AssemblaResponse response = new AssemblaResponse(Ticket.class);
		//When we get the value which has been wrapped, then it's an optional null
		assertEquals("Respose can contain null as optiona", Optional.ofNullable(null), response.getValue());
	}
	
	@Test
	public void createDefaultEmptyAssemblaResponse() {
		AssemblaResponse response = AssemblaResponse.empty();
		assertEquals("Response does not have null class" ,Optional.ofNullable(null), response.getType());
		assertEquals("Response does not have null value" , Optional.ofNullable(null), response.getValue());
		
	}
	
	@Test
	public void createPagedRequestTest() {
		//Given a new paged resquest
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test",Ticket[].class);
		pagedRequest.addParam("key", "value");
		//When we interogate the object then all of the values have been initalised to the default value 
		assertEquals("Default page size is not set correcty", AssemblaConstants.DEFAULT_PAGE_SIZE, pagedRequest.getPageSize());
		assertEquals("Default page is not set correcty", AssemblaConstants.DEFAULT_PAGE, pagedRequest.getPage());
		
		StringBuilder sb = new StringBuilder("paged_test?")
		.append("key=value&")
		.append(AssemblaConstants.PAGE_PARAMETER)
		.append("=")
		.append(pagedRequest.getPage())
		.append("&")
		.append(AssemblaConstants.PAGE_SIZE_PARAMETER)
		.append("=")
		.append(pagedRequest.getPageSize());
		
		assertEquals("URL Does not contain page parameters", sb.toString(), pagedRequest.getFullURI());
		
	}
	
	@Test
	public void createdPagedIteratorTest() {

		//Given a paged request with default page settings
		AssemblaClient client = Mockito.mock(AssemblaClient.class);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test", Ticket[].class);
		PagedIterator<Ticket> it = new PagedIterator<>(pagedRequest, client);

		//When we interogate the request, it's been initialized and has not made a request
		assertEquals("Client has not been set", client, it.getClient());
		assertEquals("Request has not been set", pagedRequest, it.getRequest());
		assertEquals("Has next as first iteration", true, it.hasNext());
		Mockito.verify(client, Mockito.never()).get(Mockito.any(AssemblaRequest.class));
		
	}
	
	@Test
	public void makePagedGETRequestTest() {
		//Given a paged request with default page settings
		AssemblaClient client = Mockito.mock(AssemblaClient.class);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test", Ticket[].class);
		PagedIterator<Ticket> it = new PagedIterator<>(pagedRequest, client);
		
		Ticket[] ticketList = new Ticket[25];
		Arrays.fill(ticketList, new Ticket());
		Mockito.when(client.get(pagedRequest)).thenReturn(new AssemblaResponse(ticketList , Ticket[].class));
		
		//When we get the next page
		Collection<Ticket> tickets = it.next();
		
		//Then we are returned a page of results
		//FIXME: hasItem not found in org.hamcrest.CoreMatchers
		//Assert.assertThat(tickets, hasItems(ticketList));
		assertEquals("Iterator has not moved onto next page" , 2 , it.getRequest().getPage());
		Mockito.verify(client).get(Mockito.any(AssemblaRequest.class));
	}
	
	
	@Test
	public void makePagedGETRequestWithParamTest() {
		//Given a paged request with default page settings
		AssemblaClient client = Mockito.mock(AssemblaClient.class);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test", Ticket[].class);
		pagedRequest.addParam("key", "value");
		PagedIterator<Ticket> it = new PagedIterator<>(pagedRequest, client);
		
		Ticket[] ticketList = new Ticket[25];
		Arrays.fill(ticketList, new Ticket());
		Mockito.when(client.get(pagedRequest)).thenReturn(new AssemblaResponse(ticketList , Ticket[].class));
		
		StringBuilder sb = new StringBuilder("paged_test?")
		.append("key=value&")
		.append(AssemblaConstants.PAGE_PARAMETER)
		.append("=")
		.append(1)
		.append("&")
		.append(AssemblaConstants.PAGE_SIZE_PARAMETER)
		.append("=")
		.append(AssemblaConstants.DEFAULT_PAGE_SIZE);	
		
		assertEquals("URL for next request does not have correct parameters", sb.toString(),  it.getRequest().getFullURI());
		it.next();
		
		 sb = new StringBuilder("paged_test?")
		.append("key=value&")
		.append(AssemblaConstants.PAGE_PARAMETER)
		.append("=")
		.append(2)
		.append("&")
		.append(AssemblaConstants.PAGE_SIZE_PARAMETER)
		.append("=")
		.append(AssemblaConstants.DEFAULT_PAGE_SIZE);	
		
		 assertEquals("URL for next request does not have correct parameters", sb.toString(),  it.getRequest().getFullURI());
	}
	
	@Test()
	public void pagedIteratorNoElementTest() {
		AssemblaClient client = Mockito.mock(AssemblaClient.class);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test", Ticket[].class);

		Mockito.when(client.get(pagedRequest)).thenReturn(new AssemblaResponse());
		
		PagedIterator<Ticket> it = new PagedIterator<>(pagedRequest, client);
		
		assertEquals("No elements returned" , Collections.emptyList() , it.next());
		assertFalse("Should have no more elements to return", it.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void pagedIteratorNoElements() {
		AssemblaClient client = Mockito.mock(AssemblaClient.class);
		PagedAssemblaRequest pagedRequest = new PagedAssemblaRequest("paged_test", Ticket[].class);
		Mockito.when(client.get(pagedRequest)).thenReturn(new AssemblaResponse());
		
		PagedIterator<Ticket> it = new PagedIterator<>(pagedRequest, client);
		it.next();
		it.next();
	}

	@Test(expected=IllegalArgumentException.class)
	public void pagedRequestHasToBeArrayTest() {
		new PagedAssemblaRequest("paged_test", Ticket.class);
	}
	
	@Test
	public void assemblaRequestAddAllParameters() {
		AssemblaRequest request = new AssemblaRequest("test_url", Ticket.class);
		Map<String, Object> params = new HashMap<>();
		params.put("key", "value");
		params.put("key2", "value2");
		request.addAllParameters(params);
		request.addParam("key3", "value3");
		
		assertTrue("key does not exist in parameters", request.getParameters().containsKey("key"));
		assertEquals("key has wrong value in parameters", "value" , request.getParameters().get("key"));
		
		assertTrue("key2 does not exist in parameters", request.getParameters().containsKey("key2"));
		assertEquals("key2 has wrong value in parameters", "value2" , request.getParameters().get("key2"));

		assertTrue("key3 does not exist in parameters", request.getParameters().containsKey("key3"));
		assertEquals("key3 has wrong value in parameters", "value3" , request.getParameters().get("key3"));
	}
	
	
	@Test
	public void uploadRequestCreation() {
		UploadAssemblaRequest upload = new UploadAssemblaRequest("uri", Document.class, item);
		assertEquals(this.item, upload.getUploadableItem());
	}
	
	@Test
	public void assemblaRequestWithMultipleValuesForKey() {
		AssemblaRequest request = new AssemblaRequest("test.json");
		request.addParam("key", "value1", "value2","value3");
		
		String expected = "test.json?key=value1&key=value2&key=value3";
		assertEquals( expected, request.getFullURI());
	}
	
}
