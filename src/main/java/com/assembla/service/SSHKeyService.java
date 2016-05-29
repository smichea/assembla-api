package com.assembla.service;

import java.util.List;

import com.assembla.SSHKey;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaConstants;
import com.assembla.client.AssemblaRequest;
import com.assembla.utils.ValidationUtils;

public class SSHKeyService extends AbstractBaseService {

	public SSHKeyService(AssemblaClient assemblaClient) {
		super(assemblaClient, null);
	}

	public List<SSHKey> getAll() {
		AssemblaRequest request = new AssemblaRequest(AssemblaConstants.SSH_KEY_ALL, SSHKey[].class);
		return super.getList(request);
	}

	public SSHKey get(Integer id) {
		ValidationUtils.notNull(id, "id == null");
		String uri = String.format(AssemblaConstants.SSH_KEY, id);
		AssemblaRequest request = new AssemblaRequest(uri, SSHKey.class);
		return super.get(request, String.format("No SSHKey with id %d exists", id));
	}

	public SSHKey create(SSHKey sshKey) {
		ValidationUtils.notNull(sshKey, "sshKey == null");
		AssemblaRequest request = new AssemblaRequest(AssemblaConstants.SSH_KEY_ALL, SSHKey.class);
		request.withBody(sshKey);
		return super.post(request);
	}

	public void update(SSHKey sshKey) {
		ValidationUtils.notNull(sshKey, "sshKey == null");
		ValidationUtils.notNull(sshKey.getId(), "SSHKey must have an id");
		String uri = String.format(AssemblaConstants.SSH_KEY, sshKey.getId());
		AssemblaRequest request = new AssemblaRequest(uri);
		request.withBody(sshKey);
		super.client.put(request);
	}

	public void delete(int id) {
		String uri = String.format(AssemblaConstants.SSH_KEY, id);
		AssemblaRequest request = new AssemblaRequest(uri);
		super.client.delete(request);
	}

}
