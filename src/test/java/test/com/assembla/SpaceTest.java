package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.TeamPermission;
import com.assembla.WatcherPermission;
import com.assembla.Space.SpaceStatus;
import com.assembla.Space.TeamTabRole;

public class SpaceTest {

	@Test
	public void watcherPermissionsCorrect() {
		assertEquals(1, WatcherPermission.READ.getValue().intValue());
	}

	@Test
	public void watcherPermissionsByValueCorrect() {
		assertEquals(WatcherPermission.READ, WatcherPermission.parse(1));
	}

	@Test
	public void spaceStatusCorrect() {
		assertEquals(0, SpaceStatus.PROPOSED.getValue().intValue());
		assertEquals(1, SpaceStatus.ACTIVE.getValue().intValue());
		assertEquals(2, SpaceStatus.ARCHIVED.getValue().intValue());
		assertEquals(4, SpaceStatus.SHARED.getValue().intValue());
	}

	@Test
	public void spaceStatusByValue() {
		assertEquals(SpaceStatus.PROPOSED, SpaceStatus.parse(0));
		assertEquals(SpaceStatus.ACTIVE, SpaceStatus.parse(1));
		assertEquals(SpaceStatus.ARCHIVED, SpaceStatus.parse(2));
		assertEquals(SpaceStatus.SHARED, SpaceStatus.parse(4));
	}

	@Test
	public void teamTabRolesCorrect() {
		assertEquals(0, TeamTabRole.ALL.getValue().intValue());
		assertEquals(10, TeamTabRole.WATCHERS_AND_USERS.getValue().intValue());
		assertEquals(50, TeamTabRole.MEMBERS_AND_USERS.getValue().intValue());
		assertEquals(90, TeamTabRole.OWNER.getValue().intValue());
	}

	@Test
	public void teamTabRolesByValue() {
		assertEquals(TeamTabRole.ALL, TeamTabRole.parse(0));
		assertEquals(TeamTabRole.WATCHERS_AND_USERS, TeamTabRole.parse(10));
		assertEquals(TeamTabRole.MEMBERS_AND_USERS, TeamTabRole.parse(50));
		assertEquals(TeamTabRole.OWNER, TeamTabRole.parse(90));
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalTeamTabRoleParsed() {
		TeamTabRole.parse(999);
	}

	@Test
	public void teamPermissionsCorrect() {
		assertEquals(1, TeamPermission.READ.getValue().intValue());
		assertEquals(2, TeamPermission.WRITE.getValue().intValue());
		assertEquals(3, TeamPermission.ALL.getValue().intValue());
	}

	@Test
	public void teamPermissionsByValue() {
		assertEquals(TeamPermission.READ, TeamPermission.parse(1));
		assertEquals(TeamPermission.WRITE, TeamPermission.parse(2));
		assertEquals(TeamPermission.ALL, TeamPermission.parse(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalTeamPermissionValue() {
		TeamPermission.parse(999);
	}
}
