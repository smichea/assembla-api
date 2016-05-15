package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.TicketStatus;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.enums.State;
import com.assembla.service.TicketStatusService;

@RunWith(MockitoJUnitRunner.class)
public class TicketStatusServiceTest extends ServiceTest {

	private TicketStatusService ticketStatusService;

	@Before
	public void setup() {
		ticketStatusService = new TicketStatusService(super.assemblaClient, "test_space_id");
	}

	@Test
	public void getAllStatuses() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/statuses.json", TicketStatus[].class);
		mockGet(new AssemblaResponse(new TicketStatus[10], TicketStatus[].class));
		List<TicketStatus> statuses = ticketStatusService.getAll();
		verify(assemblaClient).doGet(request);
		assertNotNull(statuses);
	}

	@Test
	public void getStatusById() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/statuses/100.json", TicketStatus.class);
		mockGet(new AssemblaResponse(new TicketStatus(), TicketStatus.class));
		TicketStatus status = ticketStatusService.get(100);
		verify(assemblaClient).doGet(request);
		assertNotNull(status);
	}

	@Test
	public void createTicketStatusSuccess() {

		TicketStatus status = new TicketStatus();
		status.setName("New Status");
		status.setState(State.OPEN);

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/statuses.json", TicketStatus.class);
		request.withBody(status);

		mockPost(new AssemblaResponse(new TicketStatus(), TicketStatus.class));
		ticketStatusService.create(status);

		verify(assemblaClient).doPost(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createTicketStatusNullStatu() {
		ticketStatusService.create(null);
	}

	@Test
	public void updateTicketStatusSuccess() {

		TicketStatus status = new TicketStatus();
		status.setId(100);
		status.setName("New Status");
		status.setState(State.CLOSED);

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/statuses/100.json", TicketStatus.class);
		request.withBody(status);

		mockPut(new AssemblaResponse(new TicketStatus(), TicketStatus.class));
		ticketStatusService.update(status);

		verify(assemblaClient).doPut(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateTicketStatusNullArg() {
		ticketStatusService.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateTicketStatusNullId() {
		TicketStatus status = new TicketStatus();
		ticketStatusService.update(status);
	}

	@Test
	public void deleteTicketStatus() {
		TicketStatus status = new TicketStatus();
		status.setId(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/statuses/100.json");
		mockDelete(new AssemblaResponse());
		ticketStatusService.delete(status);
		verify(super.assemblaClient).doDelete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteTicketStatusNullArg() {
		ticketStatusService.delete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteTicketStatusNullId() {
		TicketStatus status = new TicketStatus();
		ticketStatusService.delete(status);
	}

}