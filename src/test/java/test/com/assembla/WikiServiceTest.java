package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.WikiPage;
import com.assembla.WikiPageVersion;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.service.WikiService;

@RunWith(MockitoJUnitRunner.class)
public class WikiServiceTest extends ServiceTest {

	private WikiService wikiService;

	@Before
	public void setup() {
		this.wikiService = new WikiService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getWikiPages() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/wiki_pages.json", WikiPage[].class,
				1, 25);
		Paging paging = new Paging(1, 25);
		PagedIterator<WikiPage> pages = wikiService.getAll(paging);
		assertEquals(pages.getRequest(), request);
	}

	@Test
	public void getWikiPageById() {
		mockGet(new AssemblaResponse(new WikiPage(), WikiPage[].class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages/100.json", WikiPage.class);
		WikiPage page = wikiService.get("100");
		verify(assemblaClient).doGet(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getWikiNullidThrowsException() {
		wikiService.get(null);
	}

	@Test
	public void createWikiPage() {
		mockPost(new AssemblaResponse(new WikiPage(), WikiPage.class));
		WikiPage page = new WikiPage();
		page.setPageName("Test Page").setPosition(1);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages.json", WikiPage.class);
		request.withBody(page);

		WikiPage newPage = wikiService.create(page);

		verify(assemblaClient).doPost(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNullSpaceThrowsException() {
		wikiService.create(null);
	}

	@Test
	public void updateExistingWikiPage() {
		mockPut(new AssemblaResponse());
		WikiPage page = new WikiPage();
		page.setId("100").setPosition(2);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages/100.json");
		request.withBody(page);

		wikiService.update(page);
		verify(super.assemblaClient).doPut(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullWikiSpaceThrowsExceptionOnUpdate() {
		wikiService.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullWikiIdThrowsExceptionOnUpdate() {
		WikiPage pageNoId = new WikiPage();
		wikiService.update(pageNoId);
	}

	@Test
	public void deleteWikiPageAndChildPages() {
		mockDelete(new AssemblaResponse());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages/100/all.json");
		String id = "100";
		wikiService.deleteAll(id);
		verify(super.assemblaClient).doDelete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteWithNullidThrowsException() {
		wikiService.deleteAll(null);
	}

	@Test
	public void deleteWikiPage() {
		mockDelete(new AssemblaResponse());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages/100/container.json");
		String id = "100";
		wikiService.delete(id);
		verify(super.assemblaClient).doDelete(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteContainerWithNullIdThrowsException() {
		wikiService.delete(null);
	}

	@Test
	public void getWikiPageVersions() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/wiki_pages/100/versions.json",
				WikiPageVersion[].class, 1, 25);

		String id = "100";
		Paging paging = new Paging(1, 25);
		PagedIterator<WikiPageVersion> versions = wikiService.getVersions(id, paging);
		assertEquals(request, versions.getRequest());
	}

	@Test
	public void getWikiPageVersionsDefaultPaging() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/wiki_pages/100/versions.json",
				WikiPageVersion[].class);
		String id = "100";
		PagedIterator<WikiPageVersion> versions = wikiService.getVersions(id, null);
		assertEquals(request, versions.getRequest());
	}
	
	@Test
	public void getWikiVersionById() {
		mockGet(new AssemblaResponse(new WikiPageVersion(), WikiPageVersion.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/wiki_pages/100/versions/1.json", WikiPageVersion.class);
		String versionId = "1";
		String id = "100";
		WikiPageVersion version = wikiService.getVersion(id, versionId);
		verify(super.assemblaClient).doGet(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void wikiVersionNullIdThrowsException() {
		wikiService.getVersion(null, "100");
	}

	@Test(expected=IllegalArgumentException.class)
	public void wikiVersionNullVersionIdThrowsException() {
		wikiService.getVersion("100", null);
	}
}
