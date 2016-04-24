package com.assembla.service;
import static java.lang.String.format;

import java.util.List;

import com.assembla.Mention;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaClient;

public final class MentionService extends AbstractBaseService {

	public MentionService(AssemblaClient assemblaClient) {
		super(assemblaClient);
	}

	public List<Mention> getAll() {
		return getAll(false, false);
	}

	public List<Mention> getAllRead() {
		return getAll(true, false);
	}

	public List<Mention> getAllUnread() {
		return getAll(false, true);
	}

	private List<Mention> getAll(boolean read, boolean unread) {
		String uri = format(AssemblaConstants.MENTIONS, client.getSpaceId());
		AssemblaRequest request = new AssemblaRequest(uri, Mention[].class);
		if (read) {
			request.addParam("read", true);
		} else if (unread) {
			request.addParam("unread", true);
		}
		return super.getList(request);
	}

	public Mention getMention(int id) {
		String uri = format(AssemblaConstants.MENTION_BY_ID, id);
		AssemblaRequest request = new AssemblaRequest(uri, Mention.class);
		return super.get(request, format("Mention with id %d does not exist", id));
	}

	public void markAsRead(int id) {
		String uri = format(AssemblaConstants.MENTION_MARK_AS_READ, id);
		AssemblaRequest request = new AssemblaRequest(uri, null);
		client.doPut(request);
	}

}
