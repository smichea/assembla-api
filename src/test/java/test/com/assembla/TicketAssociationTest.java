package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.enums.TicketRelationship;

public class TicketAssociationTest {

	@Test
	public void ticketRelationshipValuesCorrect() {
		assertEquals(0, TicketRelationship.PARENT.getValue().intValue());
		assertEquals(1, TicketRelationship.CHILD.getValue().intValue());
		assertEquals(2, TicketRelationship.RELATED.getValue().intValue());
		assertEquals(3, TicketRelationship.DUPLICATE.getValue().intValue());
		assertEquals(4, TicketRelationship.SIBLING.getValue().intValue());
		assertEquals(5, TicketRelationship.STORY.getValue().intValue());
		assertEquals(6, TicketRelationship.SUBTASK.getValue().intValue());
		assertEquals(7, TicketRelationship.DEPENDANT.getValue().intValue());
		assertEquals(8, TicketRelationship.BLOCK.getValue().intValue());
	}

	@Test
	public void ticketRelationshipByValueCorrect() {
		assertEquals(TicketRelationship.PARENT, TicketRelationship.parse(0));
		assertEquals(TicketRelationship.CHILD, TicketRelationship.parse(1));
		assertEquals(TicketRelationship.RELATED, TicketRelationship.parse(2));
		assertEquals(TicketRelationship.DUPLICATE, TicketRelationship.parse(3));
		assertEquals(TicketRelationship.SIBLING, TicketRelationship.parse(4));
		assertEquals(TicketRelationship.STORY, TicketRelationship.parse(5));
		assertEquals(TicketRelationship.SUBTASK, TicketRelationship.parse(6));
		assertEquals(TicketRelationship.DEPENDANT, TicketRelationship.parse(7));
		assertEquals(TicketRelationship.BLOCK, TicketRelationship.parse(8));
	}
}
