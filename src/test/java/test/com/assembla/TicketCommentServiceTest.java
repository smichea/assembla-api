package test.com.assembla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Ticket;
import com.assembla.TicketComment;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedIterator;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.TicketCommentResource;
import com.assembla.service.TicketCommentService;

@RunWith(MockitoJUnitRunner.class)
public class TicketCommentServiceTest extends ServiceTest {

	private TicketCommentResource ticketCommentService;

	@Before
	public void setup() {
		ticketCommentService = new TicketCommentService(assemblaClient, TEST_SPACE_ID);
	}
	
	@Test
	public void getTicketCommentsTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new TicketComment[10], TicketComment[].class));
		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		PagedIterator<TicketComment> it =ticketCommentService.getAll(ticket);
		assertEquals("Request.getFullURI is incorrect","/spaces/test_space_id/tickets/100/ticket_comments.json?page=1&per_page="+AssemblaConstants.DEFAULT_PAGE_SIZE,it.getRequest().getFullURI()); 
		assertNotNull("PagedIterator == null", it);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getTicketCommentsNullTicket() {
		ticketCommentService.getAll(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getTicketCommentsNoNumber() {
		ticketCommentService.getAll(new Ticket());
	}
	
	@Test
	public void getTicketCommentTest() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new TicketComment() ,TicketComment.class));
		int id = 200;
		Ticket ticket = new Ticket();
		ticket.setNumber(1000);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/1000/ticket_comments/200.json", TicketComment.class	);
		TicketComment tc = ticketCommentService.getById(ticket, id);
		verify(assemblaClient).get(request);
	}
	
	@Test(expected=AssemblaAPIException.class)
	public void getTicketNoCommentExistsWithId() {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(TicketComment.class));
		int id = 200;
		Ticket ticket = new Ticket();
		ticket.setNumber(1000);
		TicketComment tc = ticketCommentService.getById(ticket, id);
	}
	
	@Test
	public void createTicketCommentTest() {
		TicketComment value = new TicketComment();
		when(assemblaClient.post(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(value ,TicketComment.class));
		
		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		
		TicketComment newTicketComment = value;
		newTicketComment.setComment("Test comment");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100/ticket_comments.json", TicketComment.class);
		request.withBody(newTicketComment);
		
		TicketComment comment = ticketCommentService.create(ticket, newTicketComment);
		
		verify(assemblaClient).post(request);
		assertNotNull("Comment should not be null", comment);
		assertEquals("Comment should equal one returned from client", value, comment);
	}
	
	@Test
	public void createTicketCommentTestNotCreated() {
		when(assemblaClient.post(Matchers.any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException("Error making request"));
		TicketComment ticketComment = ticketCommentService.create(new Ticket(), new TicketComment());
		assertNull("Ticket comment not created, so should be null", ticketComment);
	}
	
	@Test
	public void updateTicektCommentTest() {
		when(assemblaClient.put(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		TicketComment ticketComment = new TicketComment();
		ticketComment.setId(200);
		ticketComment.setComment("New comment");
		Ticket ticket = new Ticket();
		ticket.setNumber(1000);

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/1000/ticket_comments/200.json", null	);
		request.withBody(ticketComment);
		
		ticketCommentService.update(ticket, ticketComment);
		verify(assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateTicketCommentNullTicketTest() {
		ticketCommentService.update(null, new TicketComment());
	}

	@Test(expected=IllegalArgumentException.class)
	public void updateTicketCommentNullTicketCommentTest() {
		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		ticketCommentService.update(ticket, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void ticketCommentNoId() {
		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		TicketComment comment = new TicketComment();
		ticketCommentService.update(ticket , comment);
	}


}
