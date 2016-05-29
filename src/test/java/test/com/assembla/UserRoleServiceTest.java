package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.UserRole;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.UserRoleService;

@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceTest extends ServiceTest {

	private UserRoleService userRoleService;

	@Before
	public void setup() {
		userRoleService = new UserRoleService(super.assemblaClient, "test_space_id");
	}

	@Test
	public void getAllUserRoles() {
		mockGet(new AssemblaResponse(new UserRole[20], UserRole[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/user_roles.json", UserRole[].class);
		List<UserRole> roles = userRoleService.getAll();
		verify(super.assemblaClient).get(request);
		assertNotNull(roles);
		assertEquals("Response will be size 20", 20, roles.size());
	}

	@Test
	public void getUserRoleByIdSuccess() {
		mockGet(new AssemblaResponse(new UserRole(), UserRole.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/user_roles/1.json", UserRole.class);
		UserRole role = userRoleService.get(1);
		assertNotNull(role);
		verify(super.assemblaClient).get(request);
	}

	@Test
	public void createUserRoleSuccess() {
		super.mockPost(new AssemblaResponse(new UserRole(), UserRole.class));

		UserRole role = new UserRole();
		role.setUserId("test id");
		role.setRole("test role");

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/user_roles.json", UserRole.class);
		request.withBody(role);
		UserRole createdRole = userRoleService.create(role);

		assertNotNull(createdRole);
		verify(super.assemblaClient).post(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createUserRoleNullUserRole() {
		userRoleService.create(null);
	}

	@Test
	public void updateUserRole() {
		super.mockPut(new AssemblaResponse());
		UserRole role = new UserRole();
		role.setId(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/user_roles/100.json", UserRole.class);
		request.withBody(role);

		userRoleService.update(role);
		verify(super.assemblaClient).put(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateUserRoleNullArg() {
		userRoleService.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateRoleNoId() {
		UserRole role = new UserRole();
		// no id
		userRoleService.update(role);
	}

	@Test
	public void deleteUserRole() {
		super.mockDelete(new AssemblaResponse());
		UserRole role = new UserRole();
		role.setId(100);

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/user_roles/100.json", UserRole.class);

		userRoleService.delete(role);
		verify(super.assemblaClient).delete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNullUser() {
		userRoleService.delete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNoUserRoleId() {
		userRoleService.delete(null);
	}

}
