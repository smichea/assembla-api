package test.com.assembla;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.SpaceTool;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SpaceToolService;

@RunWith(MockitoJUnitRunner.class)
public class SpaceToolServiceTest extends ServiceTest {

	private SpaceToolService spaceToolService;

	@Before
	public void setup() {
		this.spaceToolService = new SpaceToolService(super.assemblaClient, "test_space_id");
	}

	@Test
	public void getSpaceTools() {
		mockGet(new AssemblaResponse(new SpaceTool[15], SpaceTool[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools.json", SpaceTool[].class);
		List<SpaceTool> tools = spaceToolService.getAll();
		assertNotNull(tools);
		verify(assemblaClient).doGet(request);
	}

	@Test
	public void getReopos() {
		mockGet(new AssemblaResponse(new SpaceTool[15], SpaceTool[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/repo.json", SpaceTool[].class);
		List<SpaceTool> tools = spaceToolService.getRepositories();
		assertNotNull(tools);
		verify(assemblaClient).doGet(request);
	}

	@Test
	public void getSpaceToolByIdOrNameSuccess() {
		mockGet(new AssemblaResponse(new SpaceTool(), SpaceTool.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/100.json", SpaceTool.class);
		SpaceTool tool = spaceToolService.get("100");
		assertNotNull(tool);
		verify(assemblaClient).doGet(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getSpaceBoolByIdBadArg() {
		spaceToolService.get(null);
	}

	@Test
	public void createSpaceToolSuccess() {
		mockPost(new AssemblaResponse(new SpaceTool(), SpaceTool.class));

		SpaceTool toCreate = new SpaceTool();
		toCreate.setName("Test name");
		toCreate.setToolId(9);
		SpaceTool tool = spaceToolService.create(toCreate);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/9/add.json", SpaceTool.class);
		request.withBody(toCreate);
		verify(assemblaClient).doPost(request);
		assertNotNull(tool);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSpaceToolNullSpace() {
		spaceToolService.create(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSpaceToolNoToolId() {
		SpaceTool toolWithNoId = new SpaceTool();
		spaceToolService.create(toolWithNoId);
	}

	@Test
	public void updateSpaceToolByIdSuccess() {
		SpaceTool tool = new SpaceTool();
		tool.setId("100");
		tool.setWatcherPermissions(1);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/100.json", SpaceTool.class);
		request.withBody(tool);
		spaceToolService.update(tool);
		verify(assemblaClient).doPut(request);
	}

	@Test
	public void updateSpaceToolByNameSuccess() {
		SpaceTool tool = new SpaceTool();
		tool.setName("testName");
		tool.setWatcherPermissions(1);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/testName.json", SpaceTool.class);
		request.withBody(tool);
		spaceToolService.update(tool);
		verify(assemblaClient).doPut(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateSpaceToolNoIdOrName() {
		SpaceTool tool = new SpaceTool();
		spaceToolService.update(tool);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateSpaceToolNullArg() {
		spaceToolService.update(null);
	}

	@Test
	public void deleteToolSpaceid() {
		SpaceTool tool = new SpaceTool();
		tool.setId("100");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/100.json");
		spaceToolService.delete(tool);
		verify(assemblaClient).doDelete(request);
	}

	@Test
	public void deleteSpaceToolByNameSuccess() {
		SpaceTool tool = new SpaceTool();
		tool.setName("testName");
		tool.setWatcherPermissions(1);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/testName.json");
		spaceToolService.delete(tool);
		verify(assemblaClient).doDelete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteSpaceToolNoIdOrName() {
		SpaceTool tool = new SpaceTool();
		spaceToolService.delete(tool);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteSpaceToolNullArg() {
		spaceToolService.delete(null);
	}

}
