package test.com.assembla;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

//import static org.hamcrest.collection.IsMapContaining.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.CustomReport;
import com.assembla.Document;
import com.assembla.State;
import com.assembla.Tag;
import com.assembla.Ticket;
import com.assembla.TicketReport;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.TicketRequest;
import com.assembla.service.TicketRequest.Status;
import com.assembla.service.TicketResource;
import com.assembla.service.TicketService;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest extends ServiceTest {
	
	private TicketResource ticketService;
	
	@Before
	public void setup() {
		ticketService = new TicketService(assemblaClient, TEST_SPACE_ID);
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Ticket(), Ticket.class));
		when(assemblaClient.put(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Ticket(), Ticket.class));
	}
	
	@Test
	public void getTicketByIdTest() {
		//Given a request to get a ticket by Id 123
		ticketService.getById("123");
		//When we make a request then it's equal to this request
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/id/123.json", Ticket.class);
		verify(assemblaClient).get(request);
	}
	
	@Test(expected=AssemblaAPIException.class)
	public void getTicketByIdNotFoundTest() {
		//Given a request to get a ticket by id 123, when this ticket does not exist, then throw an exception
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(Ticket.class));
		ticketService.getById("123");
	}

	@Test
	public void getTicketByNumberTest() {
		//Given a request to get ticket by number 123
		ticketService.getByNumber(123);
		//When we make a request then it's equal to this request
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/123.json", Ticket.class);
		verify(assemblaClient).get(request);
	}
	
	@Test(expected=AssemblaAPIException.class)
	public void getTicketByNumberNotFoundTest() {
		//Given a request to get a ticket by number 123, when this ticket does not exist, then throw an exception
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(Ticket.class));
		ticketService.getByNumber(123);
	}
	
	@Test
	public void getTicketsNoMilestoneTest() {
		//Given a request to get all tickets without a mile stone , when we look at the iterator returned
		PagedIterator<Ticket> tickets = ticketService.getNoMilestone();
		// Then we expect it to wrap a paged request equal to this request
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tickets/no_milestone.json", Ticket[].class);
		assertEquals(request, tickets.getRequest());
	}
	
	@Test
	public void getAllTicketsTest() {
		//Given a request to get all tickets
		PagedIterator<Ticket> tickets = ticketService.getAll();
		//When we look at the request made on client, then we expect it to be equal to this request
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tickets.json", Ticket[].class);
		assertEquals(request, tickets.getRequest());
	}	
	
	@Test
	public void getAllTicketsAssignedToUser() {
		//Given a request to get all tickets
		PagedIterator<Ticket> tickets = ticketService.getFollowed();
		//When we look at the request made on client, then we expect it to be equal to this request
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/tickets/my_followed.json", Ticket[].class);
		assertEquals(request, tickets.getRequest());
	}	
	
	@Test
	public void getAllActiveTickets() {
		//Given a request to get all user's active tickets
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Ticket[10], Ticket[].class));
		List<Ticket> tickets = ticketService.getActive();
		//When we look at the request that's made it should be equal to this request
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/my_active.json", Ticket[].class	);
		
		verify(assemblaClient).get(request);
		assertEquals("Size of list returned is equal to size of value wrapped in reponse" ,10, tickets.size());
	}
	
	@Test
	public void getAllTagsForTicket() {
		//Given a request to get tags for ticket 100
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Tag[10], Tag[].class));
		List<Tag> tags = ticketService.getTags(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100/tags.json", Tag[].class);
		//When we make the request it's equal to this request
		verify(assemblaClient).get(request);
		assertEquals("Size of List returned is size of array wrapped in response", 10, tags.size());
	}
	
	@Test
	public void getDocumentsForTicketTest() {
		//Given request to get attachments for a ticket 100
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Document[10], Document[].class));
		List<Document> documents = ticketService.getAttachments(100);
		//When we make the request then it should be equal to this request and we should return a list of Documents
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100/attachments.json", Document[].class);
		verify(assemblaClient).get(request);
		assertEquals("Size of List returned is size of array wrapped in the response", 10, documents.size());
	}
	
	@Test
	public void updateExistingTicketTest() {
		//Given a ticket with number 10
		Ticket ticket = new Ticket();
		ticket.setNumber(10);
		//When we set status to new and call update method 
		ticket.setStatus("New");
		//Then we expect a request to be made which is equal to this request  and return the updated ticket
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/10.json");
		request.withBody(ticket);
		
		ticketService.update(ticket);
		verify(assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateExistingTicketBadArgs() {
		//Given a request to update ticket without a number
		ticketService.update(new Ticket());
	}
	
	@Test
	public void getCustomReportTest() {
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new CustomReport(), CustomReport.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_reports.json", CustomReport.class);
		CustomReport report = ticketService.getCustomReports();
		verify(assemblaClient).get(request);
	}
	
	@Test
	public void deleteTicketTest() {
		//Given ticket 100, when we delete this ticket, then expect to see a request like this created
		when(assemblaClient.get(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100.json");
		ticketService.delete(ticket);
		//MAKE TEST FOR EQUALS HASH ETC
		verify(assemblaClient).delete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteTicketNull() {
		ticketService.delete(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteTicketNoNumber() {
		ticketService.delete(new Ticket());
	}
	
	@Test
	public void createNewTicketTest()	{
		Ticket expectedValue = new Ticket();
		when(assemblaClient.post(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(expectedValue, Ticket.class));
		
		Ticket ticketToCreate = new Ticket();;
		ticketToCreate.setDescription("Test ticket body");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets.json", Ticket.class);
		request.withBody(ticketToCreate);
		
		Ticket createdTicket = ticketService.create(ticketToCreate);
		verify(assemblaClient).post(request);
		assertNotNull("Created ticket is null", createdTicket);
		assertEquals("Ticket not the same as one returned", expectedValue, createdTicket);
	}
	
	@Test
	public void createTicketNotCreated() {
		when(assemblaClient.post(Matchers.any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException("Error making request"));
		Ticket ticket = ticketService.create(new Ticket());
		assertNull("Ticket should be null", ticket);
	}
	
	@Test
	public void getTicketsWithParameters() {
		TicketRequest ticketRequest = new TicketRequest.Builder()
		.report(TicketReport.ACTIVE_BY_USER)
		.sortBy("id")
		.page(2)
		.pageSize(60)
		.desc().build();
		
		PagedIterator<Ticket> tickets = ticketService.get(ticketRequest);
		Map<String, Object> parameters = tickets.getRequest().getParameters();
		
		//Non paging parameters
		assertThat(parameters, hasEntry("report", "3"));
		assertThat(parameters, hasEntry("sort_order", "desc"));
		assertThat(parameters, hasEntry("sort_by", "id"));
		
		//paging parameters
		assertEquals(tickets.getRequest().getPage(), 2);
		assertEquals(tickets.getRequest().getPageSize(), 60);
		
	}
	
	@Test
	public void getTicketsForMilestone() {
		TicketRequest ticketRequest = new TicketRequest.Builder()
		.sortBy("id")
		.page(2)
		.pageSize(60)
		.open()
		.desc().build();
		
		PagedIterator<Ticket> tickets = ticketService.getByMilestone("100", ticketRequest);

		Map<String, Object> parameters = tickets.getRequest().getParameters();
		
		//Non paging parameters
		assertThat(parameters, hasEntry("sort_order", "desc"));
		assertThat(parameters, hasEntry("sort_by", "id"));
		assertThat(parameters, hasEntry("ticket_status", "active"));
		
		//paging parameters
		assertEquals(tickets.getRequest().getPage(), 2);
		assertEquals(tickets.getRequest().getPageSize(), 60);
	}	
}
