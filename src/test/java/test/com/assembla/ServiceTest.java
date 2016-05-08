package test.com.assembla;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.mockito.Mock;

import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.exception.AssemblaAPIException;

public abstract class ServiceTest {

	protected static final String TEST_SPACE_ID = "test_space_id";

	@Mock
	protected AssemblaClient assemblaClient;

	protected void mockGet(AssemblaResponse response) {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(response);
	}

	public void mockGetWithError(String err) {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenThrow(new AssemblaAPIException(err));
	}

	public void mockPost(AssemblaResponse response) {
		when(assemblaClient.doPost(any(AssemblaRequest.class))).thenReturn(response);
	}

	public void mockPut(AssemblaResponse response) {
		when(assemblaClient.doPut(any(AssemblaRequest.class))).thenReturn(response);
	}

	public void mockDelete(AssemblaResponse response) {
		when(assemblaClient.doDelete(any(AssemblaRequest.class))).thenReturn(response);
	}
}

