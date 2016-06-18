package test.com.assembla;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.Event;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.service.ActivityResource;
import com.assembla.service.ActivityService;
import com.assembla.service.DateRange;

@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceTest extends ServiceTest {

	private ActivityResource activityService;

	@Before
	public void setup() {
		activityService = new ActivityService(super.assemblaClient, TEST_SPACE_ID);

	}

	@Test
	public void returnPageOfActivity() {
		PagedIterator<Event> events = activityService.get();
		PagedAssemblaRequest request = new PagedAssemblaRequest("/activity.json", Event[].class);
		assertEquals("PagedAssemblaRequest not equal to expected value", request, events.getRequest());
	}

	@Test
	public void returnPageOfActivityByDate() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		LocalDateTime dt2 = LocalDateTime.of(2016, Month.JUNE, 1, 0, 0);
		DateRange range = new DateRange(dt1, dt2);

		PagedIterator<Event> events = activityService.get(dt1, dt2);
		PagedAssemblaRequest request = new PagedAssemblaRequest("/activity.json", Event[].class);
		request.addParam("from", range.getFromString());
		request.addParam("to", range.getToString());

		assertTrue("Request does not have to parameter", events.getRequest().getParameters().containsKey("to"));
		assertTrue("Request does not have from parameter",events.getRequest().getParameters().containsKey("from"));
		assertEquals("Request from parameter wrong format", "2016-06-01 00:00", events.getRequest().getParameters().get("to"));
		assertEquals("Request from parameter wrong format", "2016-05-01 00:00", events.getRequest().getParameters().get("from"));
	}

	@Test
	public void datePeriodWrapperTest() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		LocalDateTime dt2 = LocalDateTime.of(2016, Month.JUNE, 1, 0, 0);

		DateRange range = new DateRange(dt1, dt2);
		assertEquals(dt1, range.getFrom());
		assertEquals(dt2, range.getTo());

		assertEquals("2016-05-01 00:00", range.getFromString());
		assertEquals("2016-06-01 00:00", range.getToString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void datePeriodNullStart() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		DateRange range = new DateRange(null, dt1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void datePeriodNullEnd() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		DateRange range = new DateRange(dt1, null);
	}

	@Test()
	public void datePeriodFormatterDefault() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		DateRange range = new DateRange(dt1, dt1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		assertEquals(formatter.format(dt1), range.getFromString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void datePeriodFormatterEndBeforeStart() {
		LocalDateTime dt1 = LocalDateTime.of(2016, Month.MAY, 1, 0, 0);
		LocalDateTime dt2 = LocalDateTime.of(2016, Month.MARCH, 1, 0, 0);
		DateRange range = new DateRange(dt1, dt2);
	}

}
