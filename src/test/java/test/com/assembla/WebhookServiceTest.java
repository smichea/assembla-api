package test.com.assembla;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assembla.Webhook;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.service.WebhookService;

@RunWith(MockitoJUnitRunner.class)
public class WebhookServiceTest extends ServiceTest {

	private WebhookService service;

	@Before
	public void setup() {
		this.service = new WebhookService(this.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void createWebhook() {
		super.mockPost(new AssemblaResponse(new Webhook(), Webhook.class));
		Webhook newHook = new Webhook();
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/webhooks.json", Webhook.class);
		request.withBody(newHook);

		service.create(newHook);

		verify(super.assemblaClient).post(request);
	}

	@Test
	public void updateWebhook() {
		super.mockPut(AssemblaResponse.empty());
		Webhook webhook = new Webhook();
		webhook.setId(1);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/webhooks/1.json");
		request.withBody(webhook);
		service.update(webhook);

		verify(super.assemblaClient).put(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateNullWebhookThrowsException() {
		service.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateNullWebhookIdThrowsException() {
		service.update(new Webhook());
	}

	@Test
	public void deleteWebhook() {
		super.mockDelete(AssemblaResponse.empty());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/webhooks/1.json");
		service.delete(1);
		verify(super.assemblaClient).delete(request);
	}
}
