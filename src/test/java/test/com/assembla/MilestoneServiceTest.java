package test.com.assembla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Milestone;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.MilestoneService;

@RunWith(MockitoJUnitRunner.class)
public class MilestoneServiceTest extends ServiceTest {

	private MilestoneService milestoneService;
	
	@Before
	public void setup() {
		milestoneService = new MilestoneService(super.assemblaClient, TEST_SPACE_ID);

	}
	
	@Test
	public void upcomingMilestoneTest() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/milestones/upcoming.json", Milestone[].class);
		PagedIterator<Milestone> milestones = milestoneService.getUpcoming();
		assertNotNull(milestones);
		assertEquals("Request on iterator should be equal to example request", request, milestones.getRequest());
	}
	
	@Test
	public void getAllMilestonesTest() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/milestones/all.json", Milestone[].class);
		PagedIterator<Milestone> milestones = milestoneService.getAll();
		assertNotNull(milestones);
		assertEquals("Request on iterator should be equal to example request", request, milestones.getRequest());
	}
	
	@Test
	public void getAllCompletedMilestonesTest() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/milestones/completed.json", Milestone[].class);
		PagedIterator<Milestone> milestones = milestoneService.getCompleted();
		assertNotNull(milestones);
		assertEquals("Request on iterator should be equal to example request", request, milestones.getRequest());
	}
	
	@Test
	public void getAllReleaseMilestones() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/milestones/release_notes.json", Milestone[].class);
		PagedIterator<Milestone> milestones = milestoneService.getReleases();
		assertNotNull(milestones);
		assertEquals("Request on iterator should be equal to example request", request, milestones.getRequest());
	}
	
	@Test
	public void getMilestoneByIdTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(new Milestone(), Milestone.class))	;
		String milestoneId = "milestoneId";
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/milestones/milestoneId.json", Milestone.class);
		milestoneService.get(milestoneId);
		verify(assemblaClient).doGet(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getByIdBadArgTest() {
		milestoneService.get(null);
	}
	
	@Test
	public void createMilestoneSuccessTest() {
		Milestone expectedValue = new Milestone();
		when(assemblaClient.doPost(Matchers.any(AssemblaRequest.class))).thenReturn(new AssemblaResponse(expectedValue, Milestone.class));
		
		Milestone milestoneToCreate = new Milestone();;
		milestoneToCreate.setDescription("Test milestone body");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/milestones.json", Milestone.class);
		request.withBody(milestoneToCreate);
		
		Milestone createdMilestone = milestoneService.create(milestoneToCreate);
		verify(assemblaClient).doPost(request);
		assertNotNull("Created milestone is null", createdMilestone);
		assertEquals("Milestone not the same as one returned", expectedValue, createdMilestone);
	}
	
	@Test
	public void createMilestoneFailTest() {
		when(assemblaClient.doPost(any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException("Error making request"));
		Milestone milestone = milestoneService.create(new Milestone());
		assertNull("Milestone should be null", milestone);
	}
	
	@Test
	public void updateMilestoneSuccessTest() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/milestones/test_id.json", Milestone.class);
		Milestone milestone = new Milestone();
		milestone.setId("test_id");
		request.withBody(milestone);
		
		milestoneService.update(milestone);
		verify(assemblaClient).doPut(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateMilestoneBadArgs() {
		milestoneService.update(null);
	}
	
	@Test
	public void deleteMilestoneTest() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/milestones/test_id.json", Milestone.class);
		Milestone milestone = new Milestone();
		milestone.setId("test_id");
		request.withBody(milestone);
		milestoneService.delete(milestone);
		verify(assemblaClient).doDelete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteBadArgTest() {
		milestoneService.delete(null);
	}
	
}
