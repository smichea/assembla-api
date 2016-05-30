package com.assembla.service;

import java.util.List;

import com.assembla.PrivateSSHKey;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;

public class SpaceSSHKeyService extends AbstractBaseService {

	public SpaceSSHKeyService(AssemblaClient assemblaClient, String spaceId) {
		super(assemblaClient, spaceId);
	}

	public List<PrivateSSHKey> getAll() {
		String uri = String.format(AssemblaConstants.SPACE_SSH_KEYS, this.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, PrivateSSHKey[].class);
		return super.getList(request);
	}

	public PrivateSSHKey generate() {
		String uri = String.format(AssemblaConstants.SPACE_SSH_KEY_GENERATE, this.spaceId);
		AssemblaRequest request = new AssemblaRequest(uri, PrivateSSHKey.class);
		return super.post(request);
	}

}
