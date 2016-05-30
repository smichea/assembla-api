package test.com.assembla;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.SSHAction;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SSHActionService;

@RunWith(MockitoJUnitRunner.class)
public class SSHActionServiceTest extends ServiceTest {

	private SSHActionService service;

	@Before
	public void setup() {
		service = new SSHActionService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getSSHActions() {
		super.mockGet(new AssemblaResponse(new SSHAction[10], SSHAction[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions.json", SSHAction[].class);
		List<SSHAction> actions = service.getAll();
		verify(super.assemblaClient).get(request);
	}
	
	@Test
	public void getSSHActionById() {
		super.mockGet(new AssemblaResponse(new SSHAction(), SSHAction.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions/100.json", SSHAction.class);
		SSHAction action = service.get(100);
		verify(assemblaClient).get(request);
	}
	
	@Test
	public void createSSHAction() {
		super.mockPost(new AssemblaResponse(new SSHAction(), SSHAction.class));
		SSHAction action = new SSHAction();
		action.setName("test name");
		
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions.json", SSHAction.class);
		request.withBody(action);
		
		SSHAction newAction = service.create(action);
		verify(super.assemblaClient).post(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createSSHActionNullActionThrowsException() {
		service.create(null);
	}
	
	@Test
	public void updateSSHAction() {
		super.mockPut(AssemblaResponse.empty());
		SSHAction existingAction = new SSHAction();
		existingAction.setId(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions/100.json", SSHAction.class);
		request.withBody(existingAction);
		
		service.update(existingAction);
		verify(super.assemblaClient).put(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateSSHActionNullThrowsException() {
		service.update(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateSSHActionNullIdThrowsException() {
		SSHAction action = new SSHAction();
		service.update(action);
	}
	
	@Test
	public void deleteSSHAction() {
		mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions/100.json");
		service.delete(100);
		verify(super.assemblaClient).delete(request);
	}
	
	@Test
	public void runSSHAction() {
		mockGet(new AssemblaResponse(new SSHAction(), SSHAction.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions/100/run.json", SSHAction.class);
		SSHAction action = service.run(100);
		verify(super.assemblaClient).get(request);
	}
}
