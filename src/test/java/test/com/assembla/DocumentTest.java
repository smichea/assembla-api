package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.enums.AttachableType;

public class DocumentTest {

	@Test
	public void attachableTypeStringCorrect() {
		assertEquals("Ticket", AttachableType.TICKET.getValue());
		assertEquals("Flow", AttachableType.FLOW.getValue());
		assertEquals("Milestone", AttachableType.MILESTONE.getValue());
	}

	@Test
	public void attachableTypeByStringCorrect() {
		assertEquals(AttachableType.TICKET, AttachableType.parse("Ticket"));
		assertEquals(AttachableType.FLOW, AttachableType.parse("Flow"));
		assertEquals(AttachableType.MILESTONE, AttachableType.parse("Milestone"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void attachableTypeByStringAnyCaseCorrect() {
		assertEquals(AttachableType.TICKET, AttachableType.parse("tICket"));
	}
}
