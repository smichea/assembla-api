package test.com.assembla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.User;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends ServiceTest {

	private UserService userService;
	
	@Before
	public void setup() {
		userService = new UserService(super.assemblaClient, TEST_SPACE_ID);
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new User(), User.class));
	}
	
	@Test
	public void getUserTest() {
		//Given request to get currently authenticated user
		AssemblaRequest request = new AssemblaRequest("/user.json", User.class);
		//When we make the request
		userService.getUser();
		//Then we exepct request to be same as this
		verify(assemblaClient).doGet(request);
	}
	
	@Test
	public void getUserByIdOrLoginTest() {
		//Given request to get a user with id/login test-user-name
		AssemblaRequest request = new AssemblaRequest("/users/test-user-name.json", User.class);
		String name = "test-user-name";
		//When we make the request
		User user = userService.getUser(name);
		//Then we exepct request to be same as this, user to not be empty
		verify(assemblaClient).doGet(request);
		assertNotNull(user);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getUserByIdOrLoginNull() {	
		userService.getUser(null);
	}
	
	@Test(expected = AssemblaAPIException.class)
	public void getUserNotFoundThrowsException() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(null, User.class));
		userService.getUser("DOESNT EXIST");
	}
	
	@Test
	public void getUsersForCurrentSpaceContextTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new User[10], User[].class));
		//Given request to get a user with id/login test-user-name
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/users.json", User[].class);
		//When we make the request
		List<User> users = userService.getUsersForSpace();
		//Then we exepct request to be same as this, user to not be empty
		verify(assemblaClient).doGet(request);
		assertNotNull(users);
	}
	
	@Test
	public void getUsersForSpaceNoUsers() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(User[].class));
		//Given request to get a user with id/login test-user-name
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/users.json", User[].class);
		//When we make the request
		List<User> users = userService.getUsersForSpace();
		//Then we exepct request to be same as this, user to not be empty
		verify(assemblaClient).doGet(request);
		assertEquals("User list is not empty", Collections.emptyList(), users);
	}

}
