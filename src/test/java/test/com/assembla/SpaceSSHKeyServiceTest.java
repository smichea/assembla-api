package test.com.assembla;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.PrivateSSHKey;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.SpaceSSHKeyService;

@RunWith(MockitoJUnitRunner.class)
public class SpaceSSHKeyServiceTest extends ServiceTest {

	private SpaceSSHKeyService service;

	@Before
	public void setup() {
		service = new SpaceSSHKeyService(this.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getSpaceSSHKeys() {
		super.mockGet(new AssemblaResponse(new PrivateSSHKey[10], PrivateSSHKey[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/key.json", PrivateSSHKey[].class);
		List<PrivateSSHKey> keys = service.getAll();
		verify(super.assemblaClient).get(request);
	}
	@Test
	public void generateSpaceSSHKey() {
		super.mockPost(new AssemblaResponse(new PrivateSSHKey(), PrivateSSHKey.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/ssh/generate_key.json", PrivateSSHKey.class	);
		PrivateSSHKey key = service.generate();
		verify(super.assemblaClient).post(request);
	}
}
