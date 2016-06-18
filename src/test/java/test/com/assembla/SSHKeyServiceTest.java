package test.com.assembla;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.SSHKey;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SSHKeyResource;
import com.assembla.service.SSHKeyService;

@RunWith(MockitoJUnitRunner.class)
public class SSHKeyServiceTest extends ServiceTest {
	private SSHKeyResource sshService;

	@Before
	public void setup() {
		this.sshService = new SSHKeyService(super.assemblaClient);
	}

	@Test
	public void getAllSSHActions() {
		mockGet(new AssemblaResponse(new SSHKey[10], SSHKey[].class));
		AssemblaRequest request = new AssemblaRequest("/user/ssh_keys.json", SSHKey[].class);
		List<SSHKey> keys = sshService.getAll();
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void sshKeyById() {
		mockGet(new AssemblaResponse(new SSHKey(), SSHKey.class));
		AssemblaRequest request = new AssemblaRequest("/user/ssh_keys/100.json", SSHKey.class);
		Integer id = 100;
		SSHKey key = sshService.get(id);
		verify(assemblaClient).get(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sshKeyByNullIdThrowsException() {
		sshService.get(null);
	}

	@Test
	public void create() {
		mockPost(new AssemblaResponse(new SSHKey(), SSHKey.class));
		SSHKey sshKey = new SSHKey();
		sshKey.setKey("ssh-dss+AAAAB3NzaC1kc3MA....");
		AssemblaRequest request = new AssemblaRequest("/user/ssh_keys.json", SSHKey.class);
		request.withBody(sshKey);

		SSHKey createdKey = sshService.create(sshKey);
		verify(super.assemblaClient).post(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createWithNullSSHKeyThrowsException() {
		sshService.create(null);
	}

	@Test
	public void updateKey() {
		mockPut(AssemblaResponse.empty());
		SSHKey sshKey = new SSHKey();
		sshKey.setId(100);

		AssemblaRequest request = new AssemblaRequest("/user/ssh_keys/100.json");
		request.withBody(sshKey);

		sshService.update(sshKey);
		verify(assemblaClient).put(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateWithNullSSHKeyThrowsException() {
		sshService.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateWithSSHKeyNoIdThrowsException() {
		sshService.update(new SSHKey());
	}

	@Test
	public void deleteSSHKey() {
		mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/user/ssh_keys/100.json");
		sshService.delete(100);
		verify(super.assemblaClient).delete(request);
	}
}
