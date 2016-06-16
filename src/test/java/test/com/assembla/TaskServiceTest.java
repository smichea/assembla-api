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
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.service.TaskRequest;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest extends ServiceTest {

	private TaskService service;

	@Before
	public void setup() {
		service = new TaskService(super.assemblaClient);
	}

	@Test
	public void getTasks() {
		super.mockGet(new AssemblaResponse(new Task[10], Task[].class));

		PagedAssemblaRequest request = new PagedAssemblaRequest("/tasks.json", Task[].class, 1, 100);

		LocalDateTime start = LocalDateTime.of(2016, 06, 10, 0, 0);
		LocalDateTime end = LocalDateTime.of(2016, 07, 10, 1, 0);

		TaskRequest taskRequest = new TaskRequest.Builder()
		.userIds(Arrays.asList("100"))
		.spaceIds(Arrays.asList("200"))
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
		assertThat(parameters, hasEntry("spaces[]", "space_id&spaces[]=another_space_id"));

	}

	@Test
	public void taskRequestTest() {

	}

}
