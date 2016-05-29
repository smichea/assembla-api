package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.MergeRequest;
import com.assembla.MergeRequestComment;
import com.assembla.Ticket;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.service.MergeRequestService;

@RunWith(MockitoJUnitRunner.class)
public class MergeRequestServiceTest extends ServiceTest {

	private MergeRequestService mrService;

	@Before
	public void setup() {
		this.mrService = new MergeRequestService(this.assemblaClient, TEST_SPACE_ID, 12);
	}

	@Test
	public void spaceToolIdSetOnService() {
		assertEquals(12, this.mrService.getSpaceToolId());
		this.mrService.setSpaceToolId(22);
		assertEquals(22, this.mrService.getSpaceToolId());

	}

	@Test
	public void getAllMergeRequestNoParams() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests.json",
				MergeRequest[].class);
		PagedIterator<MergeRequest> result = mrService.mergeRequests();
		assertEquals(request, result.getRequest());
	}

	@Test
	public void getAllMergeRequestStatusAndPagingParam() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests.json",
				MergeRequest[].class, 1, 10);
		request.addParam("status", "open");

		Paging paging = new Paging(1, 10);
		PagedIterator<MergeRequest> result = mrService.mergeRequests(paging, MergeRequest.Status.OPEN);
		assertEquals(request, result.getRequest());
	}

	@Test
	public void getAllMergeRequestNoPaging() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests.json",
				MergeRequest[].class);
		request.addParam("status", "open");
		PagedIterator<MergeRequest> result = mrService.mergeRequests(null, MergeRequest.Status.OPEN);
		assertEquals(request, result.getRequest());
	}

	@Test
	public void createNewMergeRequest() {
		super.mockPost(new AssemblaResponse(new MergeRequest(), MergeRequest.class));
		MergeRequest mr = new MergeRequest();
		mr.setSourceSymbol("target").setTargetSymbol("master");

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests.json",
				MergeRequest.class);
		request.withBody(mr);

		MergeRequest merge = mrService.create(mr);

		assertNotNull(merge);
		verify(assemblaClient).post(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullMergeRequest() {
		mrService.create(null);
	}

	@Test
	public void getMergeRequestById() {
		super.mockGet(new AssemblaResponse(new MergeRequest(), MergeRequest.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests/12345.json",
				MergeRequest.class);
		MergeRequest mr = mrService.get(12345);
		assertNotNull(mr);
		verify(assemblaClient).get(request);
	}

	@Test
	public void getMergeRequestComment() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/12345/comments.json", MergeRequestComment[].class, 1,
				25);

		int mergeRequestId = 12345;
		Paging paging = new Paging(1, 25);
		PagedIterator<MergeRequestComment> comments = mrService.getComments(mergeRequestId, paging);
		assertNotNull(comments);
		assertEquals(request, comments.getRequest());
	}

	@Test
	public void nullPagingArgument() {
		PagedAssemblaRequest request = new PagedAssemblaRequest(
				"/spaces/test_space_id/space_tools/12/merge_requests/12345/comments.json", MergeRequestComment[].class);

		int mergeRequestId = 12345;
		PagedIterator<MergeRequestComment> comments = mrService.getComments(mergeRequestId, null);
		assertNotNull(comments);
		assertEquals(request, comments.getRequest());
	}
	
	@Test
	public void applyAndMergeRequest() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests/12345/merge_and_close.json");
		int id = 12345;
		mrService.mergeAndClose(id);
		verify(assemblaClient).put(request);
	}
	
	@Test
	public void ignoreMergeRequest() {
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests/12345/ignore.json");
		int id = 12345;
		mrService.ignore(id);
		verify(assemblaClient).put(request);
	}
	
	@Test
	public void ticketsForMergeRequest() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests/12345/tickets.json",
				Ticket[].class, 1, 25);
		int id = 12345;
		Paging paging = new Paging(1, 25);
		PagedIterator<Ticket> tickets = mrService.associatedTickets(id, paging);
		assertEquals(request, tickets.getRequest());
	}

	@Test
	public void ticketsForMergeRequestNullPaging() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/space_tools/12/merge_requests/12345/tickets.json",
				Ticket[].class);
		int id = 12345;
		PagedIterator<Ticket> tickets = mrService.associatedTickets(id, null);
		assertEquals(request, tickets.getRequest());
	}
}
