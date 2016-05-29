package test.com.assembla.utils;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assembla.Ticket;
import com.assembla.utils.ValidationUtils;

public class ObjectUtilTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void illegalArgumentTest() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Ticket must not be null");
		ValidationUtils.notNull(null, "Ticket must not be null");
	}

	@Test
	public void correctArgumentTest() throws Exception {
		Ticket ticket = new Ticket();
		Ticket output = ValidationUtils.notNull(ticket, "Ticket must not be null");
		assertEquals(ticket, output);
	}

}
