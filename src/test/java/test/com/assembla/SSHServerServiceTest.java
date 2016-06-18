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

import com.assembla.SSHServer;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SSHServerResource;
import com.assembla.service.SSHServerService;

@RunWith(MockitoJUnitRunner.class)
public class SSHServerServiceTest extends ServiceTest {

	private SSHServerResource service;

	@Before
	public void setup() {
		service = new SSHServerService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getSSHServers() {
		super.mockGet(new AssemblaResponse(new SSHServer[10], SSHServer[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/servers.json", SSHServer[].class);
		List<SSHServer> servers = service.getAll();
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void getSSHServerById() {
		super.mockGet(new AssemblaResponse(new SSHServer(), SSHServer.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/servers/100.json", SSHServer.class);
		SSHServer server = service.get(100);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void createSSHServer() {
		super.mockPost(new AssemblaResponse(new SSHServer(), SSHServer.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/servers.json", SSHServer.class);
		SSHServer newServer = new SSHServer();
		request.withBody(newServer);
		SSHServer createdServer = service.create(newServer);
		verify(super.assemblaClient).post(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSSHServerNullThrowsException() {
		service.create(null);
	}

	@Test
	public void updateSSHServer() {
		mockPut(AssemblaResponse.empty());
		SSHServer server = new SSHServer();
		server.setId(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/servers/100.json");
		request.withBody(server);
		service.update(server);
		verify(super.assemblaClient).put(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateSSHServerNullObjectThrowsException() {
		service.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateSSHServerNullIdThrowsException() {
		SSHServer server = new SSHServer();
		service.update(server);
	}

	@Test
	public void deleteSSHServer() {
		super.mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/servers/100.json");
		service.delete(100);
		verify(super.assemblaClient).delete(request);
	}
}
