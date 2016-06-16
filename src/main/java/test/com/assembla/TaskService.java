package test.com.assembla;

import com.assembla.client.AssemblaClient;
import com.assembla.service.AbstractBaseService;

public class TaskService extends AbstractBaseService {

	public TaskService(AssemblaClient client) {
		super(client, null);
	}
}
