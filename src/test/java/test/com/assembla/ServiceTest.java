package test.com.assembla;
import org.mockito.Mock;

import com.assembla.client.AssemblaClient;

public abstract class ServiceTest {

	protected static final String TEST_SPACE_ID = "test_space_id";

	@Mock
	protected AssemblaClient assemblaClient;
}
