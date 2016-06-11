package test.com.assembla;

import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.StandupReport;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.StandupAwayReportService;

@RunWith(MockitoJUnitRunner.class)
public class StandupAwayReportServiceTest extends ServiceTest {
	private StandupAwayReportService service;

	@Before
	public void setup() {
		this.service = new StandupAwayReportService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getStandupReports() {
		super.mockGet(new AssemblaResponse(new StandupReport[10], StandupReport[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/away_standup_reports.json",
				StandupReport[].class);
		request.addParam("date", "2016-06-16");
		LocalDate date = LocalDate.of(2016, Month.JUNE, 16);
		List<StandupReport> reports = service.getAll(date);
		verify(super.assemblaClient).get(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getStandupReportsNullArgumentThrowsException() {
		service.getAll(null);
	}

	@Test
	public void getUserStandUpReport() {
		super.mockGet(new AssemblaResponse(new StandupReport(), StandupReport.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/away_standup_report.json", StandupReport.class);
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

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/away_standup_reports.json", StandupReport.class);
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
