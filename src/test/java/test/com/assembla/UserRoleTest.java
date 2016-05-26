package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.UserRole.UserRoleStatus;

public class UserRoleTest {
	@Test
	public void userRoleStatusValueCorrect() {
		assertEquals(1, UserRoleStatus.INVITED.getValue().intValue());
		assertEquals(2, UserRoleStatus.ACCEPTED.getValue().intValue());
		assertEquals(3, UserRoleStatus.REMOVED.getValue().intValue());
	}

	@Test
	public void userRoleStatusByValueCorrect() {
		assertEquals(UserRoleStatus.INVITED, UserRoleStatus.parse(1));
		assertEquals(UserRoleStatus.ACCEPTED, UserRoleStatus.parse(2));
		assertEquals(UserRoleStatus.REMOVED, UserRoleStatus.parse(3));

	}
}
