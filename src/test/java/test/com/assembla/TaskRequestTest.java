package test.com.assembla;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.assembla.client.Sort;
import com.assembla.service.DateRange;
import com.assembla.service.TaskRequest;

public class TaskRequestTest {

	@Test
	public void createDefaultTaskRequest() {
		TaskRequest request = new TaskRequest.Builder().build();
		assertFalse(request.getSortBy().isPresent());
		assertFalse(request.getDirection().isPresent());
		assertEquals(1, request.getPageNumber());
		assertEquals(75, request.getPageSize());
		assertTrue(request.getTickets().isEmpty());
		assertTrue(request.getUsers().isEmpty());
		assertTrue(request.getSpaces().isEmpty());
		assertFalse(request.getDateRange().isPresent());
	}

	@Test
	public void createTaskRequestWithSort() {
		
		TaskRequest request = new TaskRequest.Builder()
		.sortBy("ticket-id")
		.desc()
		.build();
		
		assertEquals(Sort.Direction.DESC, request.getDirection().get());
		assertEquals("ticket-id", request.getSortBy().get());
	}
	
	@Test
	public void createTaskRequestWithTicketList() {

		List<Integer> ticketIds = Arrays.asList(1, 2, 3);
		TaskRequest request = new TaskRequest.Builder()
		.ticketIds(ticketIds)
		.build();
		
		assertEquals(ticketIds, request.getTickets());
	}
	
	@Test
	public void createTaskRequestWithUserList() {
		List<String> userId = Arrays.asList("user1","user2");
		TaskRequest request = new TaskRequest.Builder()
		.userIds(userId)
		.build();
		
		assertEquals(userId, request.getUsers());
	}
	
	@Test
	public void createTaskRequestWithSpaceList() {
		List<String> spaces = Arrays.asList("space1", "space2");
		
		TaskRequest request = new TaskRequest.Builder()
		.spaceIds(spaces)
		.build();
		
		assertEquals(spaces, request.getSpaces());
	}
	
	@Test
	public void createTaskRequestWithDateRange() {
		LocalDateTime start = LocalDateTime.of(2016, Month.JUNE, 16, 10, 00);
		LocalDateTime end = LocalDateTime.of(2016, Month.JULY, 16, 10, 00);

		TaskRequest request = new TaskRequest.Builder()
		.fromTo(start, end)
		.build();
		
		assertEquals(start, request.getDateRange().get().getFrom());
		assertEquals(end, request.getDateRange().get().getTo());
		
	}
}
