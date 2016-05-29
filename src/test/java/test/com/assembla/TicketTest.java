package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.Ticket.HeirarchyType;
import com.assembla.Ticket.PermissionType;
import com.assembla.Ticket.Priority;

public class TicketTest {

	@Test
	public void hierarchyTypeCorrect() {
		assertEquals(HeirarchyType.NO_PLAN.getValue().intValue(), 0);
		assertEquals(HeirarchyType.SUB_TASK.getValue().intValue(), 1);
		assertEquals(HeirarchyType.STORY.getValue().intValue(), 2);
		assertEquals(HeirarchyType.EPIC.getValue().intValue(), 3);
	}

	@Test
	public void hierarchyByValue() {
		assertEquals(HeirarchyType.NO_PLAN, HeirarchyType.parse(0));
		assertEquals(HeirarchyType.SUB_TASK, HeirarchyType.parse(1));
		assertEquals(HeirarchyType.STORY, HeirarchyType.parse(2));
		assertEquals(HeirarchyType.EPIC, HeirarchyType.parse(3));
	}

	@Test
	public void permissionTypeCorrect() {
		assertEquals(0, PermissionType.DEVELOPMENT.getValue().intValue());
		assertEquals(1, PermissionType.SUPPORT_PRIVATE.getValue().intValue());
		assertEquals(2, PermissionType.SUPPORT_PUBLIC.getValue().intValue());
	}

	@Test
	public void ticketPermissionTypeByValue() {
		assertEquals(PermissionType.DEVELOPMENT, PermissionType.parse(0));
		assertEquals(PermissionType.SUPPORT_PRIVATE, PermissionType.parse(1));
		assertEquals(PermissionType.SUPPORT_PUBLIC, PermissionType.parse(2));
	}

	@Test
	public void ticketPriorityCorrect() {
		assertEquals(1, Priority.HIGHEST.getValue().intValue());
		assertEquals(2, Priority.HIGH.getValue().intValue());
		assertEquals(3, Priority.NORMAL.getValue().intValue());
		assertEquals(4, Priority.LOW.getValue().intValue());
		assertEquals(5, Priority.LOWEST.getValue().intValue());
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
