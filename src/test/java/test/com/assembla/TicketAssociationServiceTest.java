package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Ticket;
import com.assembla.TicketAssociation;
import com.assembla.TicketAssociation.TicketRelationship;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.TicketAssociationService;

@RunWith(MockitoJUnitRunner.class)
public class TicketAssociationServiceTest extends ServiceTest {

	private TicketAssociationService ticketAssociationService;

	@Before
	public void setup() {
		ticketAssociationService = new TicketAssociationService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void ticketAssociationTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new TicketAssociation[10], TicketAssociation[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100/ticket_associations.json",
				TicketAssociation[].class);

		Ticket ticket = new Ticket();
		ticket.setNumber(100);

		List<TicketAssociation> associations = ticketAssociationService.getAssociations(ticket);

		verify(assemblaClient).doGet(request);
		assertFalse("List of associations should not be empty", associations.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void ticketAssociationByIdBadArgsTest() {
		ticketAssociationService.getAssociations(null);
	}

	@Test
	public void getTicketAssociationByIdTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new TicketAssociation(), TicketAssociation.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/100/ticket_associations/999.json",
				TicketAssociation.class);

		Ticket ticket = new Ticket();
		ticket.setNumber(100);
		TicketAssociation association = ticketAssociationService.getAssociation(ticket, 999);

		verify(assemblaClient).doGet(request);
		assertNotNull(association);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getTIcketAssociationByIdBadArgTest() {
		ticketAssociationService.getAssociation(null, 100);
	}

	@Test
	public void createAssociationTest() {
		when(assemblaClient.doPost(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new TicketAssociation(), TicketAssociation.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/200/ticket_associations.json",
				TicketAssociation.class);

		Ticket ticket = new Ticket();
		ticket.setNumber(200);

		TicketAssociation ta1 = new TicketAssociation();
		ta1.setTicket2Id(100);
		request.withBody(ta1);

		TicketAssociation newAssociation = ticketAssociationService.create(ticket, ta1);

		assertNotNull(newAssociation);
		verify(assemblaClient).doPost(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createAssociationBadArgs() {
		ticketAssociationService.create(null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createAssociationNoIdTest() {
		ticketAssociationService.create(new Ticket(), new TicketAssociation());
	}

	@Test
	public void updateAssociationTest() {
		when(assemblaClient.doPut(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/200/ticket_associations/123456.json");

		Ticket ticket = new Ticket();
		ticket.setNumber(200);

		TicketAssociation association = new TicketAssociation();
		association.setId(123456);
		association.setTicket2Id(100);
		association.setRelationship(TicketRelationship.CHILD);
		request.withBody(association);

		ticketAssociationService.update(ticket, association);

		verify(assemblaClient).doPut(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateAssociationArgsTest() {
		ticketAssociationService.update(null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateAssociationCheckTicketTest() {
		Ticket ticket = new Ticket(); // no number

		TicketAssociation association = new TicketAssociation();
		association.setTicket2Id(100);
		association.setRelationship(TicketRelationship.CHILD);

		ticketAssociationService.update(ticket, association);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateAssociationCheckAssociationTest() {
		Ticket ticket = new Ticket();
		ticket.setNumber(100);

		// No ticket 2 id
		TicketAssociation association = new TicketAssociation();
		association.setRelationship(TicketRelationship.BLOCK);

		ticketAssociationService.update(ticket, association);
	}

	@Test
	public void deleteTicketAssociationTest() throws Exception {
		when(assemblaClient.doDelete(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/200/ticket_associations/100.json");

		Ticket ticket = new Ticket();
		ticket.setNumber(200);

		TicketAssociation association = new TicketAssociation();
		association.setId(100);

		ticketAssociationService.delete(ticket, association);
		verify(assemblaClient).doDelete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteAssociationBadArgTest() {
		ticketAssociationService.delete(null, null);
	}

}
