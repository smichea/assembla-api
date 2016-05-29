package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.SSHAction.SSHActionFrequency;
import com.assembla.SSHAction.SSHActionStatus;

public class SSHActionTest {
	@Test
	public void sshActionFreq() {
		assertEquals(0, SSHActionFrequency.MANUAL.getValue().intValue());
		assertEquals(1, SSHActionFrequency.HOURLY.getValue().intValue());
		assertEquals(2, SSHActionFrequency.DAILY.getValue().intValue());
		assertEquals(10, SSHActionFrequency.COMMIT.getValue().intValue());
		assertEquals(11, SSHActionFrequency.MERGE_REQUEST_CREATE.getValue().intValue());
		assertEquals(12, SSHActionFrequency.MERGE_REQUEST_MERGE.getValue().intValue());
	}

	@Test
	public void sshActionParse() {
		assertEquals(SSHActionFrequency.MANUAL, SSHActionFrequency.parse(0));
		assertEquals(SSHActionFrequency.HOURLY, SSHActionFrequency.parse(1));
		assertEquals(SSHActionFrequency.DAILY, SSHActionFrequency.parse(2));
		assertEquals(SSHActionFrequency.COMMIT, SSHActionFrequency.parse(10));
		assertEquals(SSHActionFrequency.MERGE_REQUEST_CREATE, SSHActionFrequency.parse(11));
		assertEquals(SSHActionFrequency.MERGE_REQUEST_MERGE, SSHActionFrequency.parse(12));
	}
	
	@Test
	public void sshActionStatus() {
		assertEquals(0, SSHActionStatus.IDLE.getValue().intValue());
		assertEquals(1, SSHActionStatus.QUEUED.getValue().intValue());
		assertEquals(2, SSHActionStatus.RUNNING.getValue().intValue());
	}
	
	@Test
	public void sshActionStatusParse() {
		assertEquals(SSHActionStatus.IDLE, SSHActionStatus.parse(0));
		assertEquals(SSHActionStatus.QUEUED, SSHActionStatus.parse(1));
		assertEquals(SSHActionStatus.RUNNING, SSHActionStatus.parse(2));
	}
}
