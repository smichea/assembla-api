package test.com.assembla;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.mockito.Mock;

import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.client.AssemblaClient;
import com.assembla.client.UploadAssemblaRequest;
import com.assembla.exception.AssemblaAPIException;

public abstract class ServiceTest {

	protected static final String TEST_SPACE_ID = "test_space_id";

	@Mock
	protected AssemblaClient assemblaClient;

	protected void mockGet(AssemblaResponse response) {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenReturn(response);
	}

	protected void mockGetWithError(String err) {
		when(assemblaClient.get(any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException(err));
	}

	protected void mockPost(AssemblaResponse response) {
		when(assemblaClient.post(any(AssemblaRequest.class))).thenReturn(response);
	}

	protected void mockPut(AssemblaResponse response) {
		when(assemblaClient.put(any(AssemblaRequest.class))).thenReturn(response);
	}

	protected void mockDelete(AssemblaResponse response) {
		when(assemblaClient.delete(any(AssemblaRequest.class))).thenReturn(response);
	}

	protected void mockMultipartPost(AssemblaResponse response) {
		when(assemblaClient.post(any(UploadAssemblaRequest.class))).thenReturn(response);
	}

	protected void mockMultipartPut(AssemblaResponse response) {
		when(assemblaClient.put(any(UploadAssemblaRequest.class))).thenReturn(response);
	}
}
