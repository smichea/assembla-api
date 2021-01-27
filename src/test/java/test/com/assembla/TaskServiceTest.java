package test.com.assembla;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Task;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedIterator;
import com.assembla.service.TaskRequest;
import com.assembla.service.TaskResource;
import com.assembla.service.TaskService;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest extends ServiceTest {

	private TaskResource service;

	@Before
	public void setup() {
		service = new TaskService(super.assemblaClient);
	}

	@Test
	public void getTasks() {
		super.mockGet(new AssemblaResponse(new Task[10], Task[].class));

		LocalDateTime start = LocalDateTime.of(2016, 06, 10, 0, 0);
		LocalDateTime end = LocalDateTime.of(2016, 07, 10, 1, 0);

		TaskRequest taskRequest = new TaskRequest.Builder()
		.userIds(Arrays.asList("100","200"))
		.spaceIds(Arrays.asList("space","space2","space3"))
		.ticketIds(Arrays.asList(12345))
		.fromTo(start, end)
		.desc()
		.sortBy("ticket-id")
		.build();
		
		PagedIterator<Task> tasks = service.getAll(taskRequest);
		Map<String, Object> parameters = tasks.getRequest().getParameters();

		assertThat(parameters, hasEntry("sort_by", "ticket-id"));
		assertThat(parameters, hasEntry("sort_order", "desc"));
		assertThat(parameters, hasEntry("from", "2016-06-10 00:00"));
		assertThat(parameters, hasEntry("to", "2016-07-10 01:00"));
		assertThat(parameters, hasEntry("spaces[]", new String[] { "space","space2","space3" }));
		assertThat(parameters, hasEntry("users[]", new String[] { "100", "200" }));
		assertThat(parameters, hasEntry("ticket_ids[]", 12345 ));

	}

	@Test(expected=IllegalArgumentException.class)
	public void nullTaskRequestThrowsException() {
		service.getAll(null);
	}
	
	@Test
	public void getTaskById() {
		super.mockGet(new AssemblaResponse(new Task(), Task.class));
		AssemblaRequest request = new AssemblaRequest("/tasks/100.json", Task.class);
		Task task = service.getTask(100);
		verify(super.assemblaClient).get(request);
	}
	
	@Test
	public void createTask() {
		super.mockPost(new AssemblaResponse(new Task(), Task.class));
		Task task = new Task();
		task.setTicketId(1234)
		.setSpaceId("test_space_id");
		AssemblaRequest request = new AssemblaRequest("/tasks.json", Task.class);
		request.withBody(task);
		
		service.create(task);
		verify(super.assemblaClient).post(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNullTaskThrowsException() {
		service.create(null);
	}
	
	@Test
	public void deleteTask() {
		super.mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/tasks/100.json");
		service.delete(100);
		verify(super.assemblaClient).delete(request);
	}
	
	@Test
	public void updateTask() {
		super.mockPut(AssemblaResponse.empty());
		Task task = new Task();	
		task.setId(100);
		AssemblaRequest request = new AssemblaRequest("/tasks/100.json");
		request.withBody(task);
		service.update(task);
		verify(super.assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateTaskNullTaskThrowsException() {
		service.update(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateTaskNullTaskIdThrowsException() {
		service.update(new Task());
	}
	
}
