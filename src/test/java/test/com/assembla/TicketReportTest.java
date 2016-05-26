package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.TicketReport;

public class TicketReportTest {

	@Test
	public void ticketReportValuesCorrect() {
		assertEquals(0, TicketReport.ALL.getValue());
		assertEquals(1, TicketReport.ACTIVE.getValue());
		assertEquals(2, TicketReport.ACTIVE_BY_COMPONENT.getValue());
		assertEquals(3, TicketReport.ACTIVE_BY_USER.getValue());
		assertEquals(4, TicketReport.CLOSED_BY_MILESTONE.getValue());
		assertEquals(5, TicketReport.CLOSED_BY_COMPONENT.getValue());
		assertEquals(6, TicketReport.CLOSED_BY_DATE.getValue());
		assertEquals(7, TicketReport.ALL_CURRENT_USER.getValue());
		assertEquals(8, TicketReport.ACTIVE_CURRENT_USER.getValue());
		assertEquals(9, TicketReport.CLOSED_CURRENT_USER.getValue());
		assertEquals(10, TicketReport.FOLLOWED_CURRENT_USER.getValue());
	}
}
