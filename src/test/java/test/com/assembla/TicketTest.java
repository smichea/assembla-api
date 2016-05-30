package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.Ticket.Priority;

public class TicketTest {

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
