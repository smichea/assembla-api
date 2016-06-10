package com.assembla.service;

import com.assembla.Webhook;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaRequest;
import com.assembla.utils.ValidationUtils;

public class WebhookService extends AbstractBaseService {

	public WebhookService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public Webhook create(Webhook webhook) {
		ValidationUtils.notNull(webhook, "webhook == null");
		String uri = String.format("/spaces/%s/webhooks.json", this.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, Webhook.class);
		request.withBody(webhook);
		return super.post(request);
	}

	public void update(Webhook webhook) {
		ValidationUtils.notNull(webhook, "webhook == null");
		ValidationUtils.notNull(webhook.getId(), "Webhook must have an id");
		String uri = String.format("/spaces/%s/webhooks/%d.json", this.spaceId, webhook.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(webhook);
		super.client.put(request);
	}

	public void delete(int id) {
		String uri = String.format("/spaces/%s/webhooks/%d.json", this.spaceId, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.delete(request);
	}

}
