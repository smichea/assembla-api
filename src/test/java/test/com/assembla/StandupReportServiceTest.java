package test.com.assembla;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.StandupReport;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.StandupReportResource;
import com.assembla.service.StandupReportService;

@RunWith(MockitoJUnitRunner.class)
public class StandupReportServiceTest extends ServiceTest {
	private StandupReportResource service;

	@Before
	public void setup() {
		this.service = new StandupReportService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getStandupReports() {
		super.mockGet(new AssemblaResponse(new StandupReport[10], StandupReport[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/standup_reports.json",
				StandupReport[].class);
		request.addParam("from", "2016-06-16");
		request.addParam("to", "2016-06-16");
		LocalDate date = LocalDate.of(2016, Month.JUNE, 16);
		List<StandupReport> reports = service.getAll(date, date);
		verify(super.assemblaClient).get(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getStandupReportsNullArgumentThrowsException() {
		service.getAll(null, LocalDate.now());
	}

	@Test
	public void getUserStandUpReport() {
		super.mockGet(new AssemblaResponse(new StandupReport(), StandupReport.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/standup_report.json", StandupReport.class);
		request.addParam("date", "2016-06-16");
		LocalDate date = LocalDate.of(2016, Month.JUNE, 16);
		StandupReport report = service.get(date);
		verify(super.assemblaClient).get(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getSingleStandupReportsNullArgumentThrowsException() {
		service.get(null);
	}

	@Test
	public void createStandupReport() {
		super.mockPost(AssemblaResponse.empty());
		StandupReport report = new StandupReport();
		report.setWhatIWillDo("create standup report service");

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/standup_reports.json", StandupReport.class);
		request.withBody(report);
		request.addParam("date", "2016-06-16");
		LocalDate date = LocalDate.of(2016, Month.JUNE, 16);
		service.create(report, date);
		 verify(super.assemblaClient).post(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createStandupReportNullReportThrowsException() {
		service.create(null, LocalDate.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createStandupReportNullDateThrowsException() {
		service.create(new StandupReport(), null);
	}

}
