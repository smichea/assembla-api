package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.HeirarchyType;
import com.assembla.PermissionType;
import com.assembla.Priority;
import com.assembla.State;

public class TicketTest {

	@Test
	public void hierarchyTypeCorrect() {
		assertEquals(HeirarchyType.NO_PLAN.getValue(), 0);
		assertEquals(HeirarchyType.SUB_TASK.getValue(), 1);
		assertEquals(HeirarchyType.STORY.getValue(), 2);
		assertEquals(HeirarchyType.EPIC.getValue(), 3);
	}
	
	@Test
	public void hierarchyByValue() {
		assertEquals(HeirarchyType.NO_PLAN, HeirarchyType.parse(0));
		assertEquals(HeirarchyType.SUB_TASK, HeirarchyType.parse(1));
		assertEquals(HeirarchyType.STORY, HeirarchyType.parse(2));
		assertEquals(HeirarchyType.EPIC, HeirarchyType.parse(3));
	}

	@Test
	public void ticketStateCorrect() {
		assertEquals(0, State.OPEN.getValue());
		assertEquals(1, State.CLOSED.getValue());
	}

	@Test
	public void ticketByValue() {
		assertEquals(State.OPEN, State.parse(0));
		assertEquals(State.CLOSED, State.parse(1));
	}

	@Test
	public void permissionTypeCorrect() {
		assertEquals(0, PermissionType.DEVELOPMENT.getValue());
		assertEquals(1, PermissionType.SUPPORT_PRIVATE.getValue());
		assertEquals(2, PermissionType.SUPPORT_PUBLIC.getValue());
	}

	@Test
	public void ticketPermissionTypeByValue() {
		assertEquals(PermissionType.DEVELOPMENT, PermissionType.parse(0));
		assertEquals(PermissionType.SUPPORT_PRIVATE, PermissionType.parse(1));
		assertEquals(PermissionType.SUPPORT_PUBLIC, PermissionType.parse(2));
	}

	@Test
	public void ticketPriorityCorrect() {
		assertEquals(1, Priority.HIGHEST.getValue());
		assertEquals(2, Priority.HIGH.getValue());
		assertEquals(3, Priority.NORMAL.getValue());
		assertEquals(4, Priority.LOW.getValue());
		assertEquals(5, Priority.LOWEST.getValue());
	}

	@Test
	public void ticketPriorityByValue() {
		assertEquals(Priority.HIGHEST, Priority.parse(1));
		assertEquals(Priority.HIGH, Priority.parse(2));
		assertEquals(Priority.NORMAL, Priority.parse(3));
		assertEquals(Priority.LOW, Priority.parse(4));
		assertEquals(Priority.LOWEST, Priority.parse(5));
	}

}
