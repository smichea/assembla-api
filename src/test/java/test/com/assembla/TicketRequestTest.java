package test.com.assembla;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.assembla.TicketReport;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.Paging;
import com.assembla.client.Sort;
import com.assembla.service.TicketRequest;

public class TicketRequestTest {
	@Test
	public void createTicketRequestObject() {
		TicketRequest request = new TicketRequest.Builder()
		.pageSize(50)
		.page(2)
		.sortBy("id")
		.desc()
		.report(TicketReport.ALL)
		.build();

		assertEquals(2, request.getPageNumber());
		assertEquals(50, request.getPageSize());
		assertEquals(Sort.Direction.DESC, request.getDirection().get());
		assertEquals("id", request.getSortBy().get());
		assertEquals(TicketReport.ALL, request.getReport().get());
	}

	@Test
	public void createTicketRequestDefaultValuesPopulated() {
		TicketRequest request = new TicketRequest.Builder().build();

		assertEquals(1, request.getPageNumber());
		assertEquals(AssemblaConstants.DEFAULT_PAGE_SIZE, request.getPageSize());
		assertEquals(Optional.empty(), request.getDirection());
		assertFalse(request.getReport().isPresent());
		assertFalse(request.getSortBy().isPresent());
	}
	
	@Test
	public void cratePagingParameterObject() {
		Paging paging = new Paging(1, 25);
		assertEquals(25, paging.size());
		assertEquals(1, paging.page());
	}

	@Test
	public void createNextPage() {
		Paging paging = new Paging(1, 25).next();
		assertEquals(2, paging.size());
		assertEquals(25, paging.page());
	}

	@Test
	public void createSortObject() {
		Sort sort = new Sort("id", Sort.Direction.DESC);
		assertEquals("Sort direction not correct", Sort.Direction.DESC, sort.getDirection());
		assertEquals("Sort field not correct", "id", sort.getField());
	}	
	
	
}
