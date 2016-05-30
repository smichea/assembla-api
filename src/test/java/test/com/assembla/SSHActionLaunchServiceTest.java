package test.com.assembla;

import static org.mockito.Mockito.*;

import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.SSHActionLaunch;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SSHActionLaunchService;

@RunWith(MockitoJUnitRunner.class)
public class SSHActionLaunchServiceTest extends ServiceTest {

	private SSHActionLaunchService service;

	@Before
	public void setup() {
		service = new SSHActionLaunchService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getSSHActionLaunches() {
		super.mockGet(new AssemblaResponse(new SSHActionLaunch[10], SSHActionLaunch[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/launches.json", SSHActionLaunch[].class);
		List<SSHActionLaunch> launches = service.getAll();
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void getSSHActionForActionId() {
		super.mockGet(new AssemblaResponse(new SSHActionLaunch[10], SSHActionLaunch[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/actions/100/launches.json",
				SSHActionLaunch[].class);
		List<SSHActionLaunch> launches = service.getAll(100);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void getSSHActionLaunch() {
		super.mockGet(new AssemblaResponse(new SSHActionLaunch(), SSHActionLaunch.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/launches/100.json", SSHActionLaunch.class);
		SSHActionLaunch launch = service.get(100);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void getSSHActionLaunchFullOutput() {
		super.mockGet(new AssemblaResponse(new SSHActionLaunch(), SSHActionLaunch.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/launches/100/output.json",
				SSHActionLaunch.class);
		SSHActionLaunch launch = service.getFullOutput(100);
		verify(super.assemblaClient).get(request);
	}
}
