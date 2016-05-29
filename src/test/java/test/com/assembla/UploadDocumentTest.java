package test.com.assembla;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Test;
import org.mockito.Mockito;

import com.assembla.Document;
import com.assembla.client.UploadableDocument;

public class UploadDocumentTest {
	@Test
	public void createDocumentToUpload() {
		File file = mock(File.class);
		when(file.exists()).thenReturn(true);
		String location = "location";
		UploadableDocument upDoc = new UploadableDocument(file, location);
		assertEquals(upDoc.fIle(), file);
		assertEquals(upDoc.location().get(), location);
		assertEquals(upDoc.namespace(), "document");
	}
}
