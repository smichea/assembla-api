package test.com.assembla;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.Document;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.PagedAssemblaRequest;
import com.assembla.client.PagedIterator;
import com.assembla.client.Paging;
import com.assembla.client.UploadAssemblaRequest;
import com.assembla.client.UploadableDocument;
import com.assembla.client.UploadableItem;
import com.assembla.service.DocumentResource;
import com.assembla.service.DocumentService;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest extends ServiceTest {

	private DocumentResource documentService;

	@Before
	public void setup() {
		this.documentService = new DocumentService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getAllDocuments() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/documents.json", Document[].class, 1,
				25);
		Paging paging = new Paging(1, 25);
		PagedIterator<Document> documents = documentService.getAll(paging);
		assertEquals(request, documents.getRequest());
	}

	@Test
	public void getAllDocumentsDefaultPaging() {
		PagedAssemblaRequest request = new PagedAssemblaRequest("/spaces/test_space_id/documents.json", Document[].class);
		PagedIterator<Document> documents = documentService.getAll(null);
		assertEquals(request, documents.getRequest());
	}

	@Test
	public void getDocumentById() {
		mockGet(new AssemblaResponse(new Document(), Document.class));
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/documents/100.json", Document.class);
		String id = "100";
		Document document = documentService.get(id);
		assertNotNull(document);
		verify(super.assemblaClient).get(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getDocumentNullIdThrowsException() {
		documentService.get(null);
	}

	@Test
	public void createNewDocument() {
		super.mockMultipartPost(new AssemblaResponse(new Document(), Document.class));
		File file = mockFile();

		String uploadPath = "some_location";
		UploadableDocument doc = new UploadableDocument(file, uploadPath);
		UploadAssemblaRequest request = new UploadAssemblaRequest("/spaces/test_space_id/documents", Document.class, doc);
		Document document = documentService.create(file, uploadPath);
		verify(super.assemblaClient).post(request);
	}

	@Test
	public void updateDocumentNoFile() {
		super.mockPut(new AssemblaResponse());
		Document docToUpdate = new Document();
		docToUpdate.setId("100");

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/documents/100.json");
		request.withBody(docToUpdate);

		documentService.update(docToUpdate);
		verify(super.assemblaClient).put(request);
	}

	@Test
	public void updateDocumentFile() {
		super.mockMultipartPut(new AssemblaResponse(new Document(), Document.class));
		File file = mockFile();
		String uploadPath = "some_location";
		String id = "100";

		UploadableDocument doc = new UploadableDocument(file, uploadPath);
		UploadAssemblaRequest request = new UploadAssemblaRequest("/spaces/test_space_id/documents/100", Document.class, doc);

		Document document = documentService.update(id, file, uploadPath);
		verify(super.assemblaClient).put(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateDocumentNullDocument() {
		documentService.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateDocumentNullId() {
		documentService.update(null, new File("test"), "test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateDocumentNullFile() {
		documentService.update("test id", null, "test");
	}

	@Test
	public void deleteDocument() {
		mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/documents/100.json");
		String id = "100";
		documentService.delete(id);
		verify(super.assemblaClient).delete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteWithNullIdThrowsException() {
		documentService.delete(null);
	}

	private File mockFile() {
		File file = Mockito.mock(File.class);
		when(file.exists()).thenReturn(true);
		return file;
	}

}
