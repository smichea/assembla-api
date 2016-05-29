package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.Milestone.ReleaseLevel;

public class MilestoneTest {

	@Test
	public void releaseLevelValuesCorrect() {
		assertEquals(1, ReleaseLevel.ALPHA.getValue().intValue());
		assertEquals(2, ReleaseLevel.BETA.getValue().intValue());
		assertEquals(3, ReleaseLevel.STABLE.getValue().intValue());
	}

	@Test
	public void releaseLevelByValuesCorrect() {
		assertEquals(ReleaseLevel.ALPHA, ReleaseLevel.parse(1));
		assertEquals(ReleaseLevel.BETA, ReleaseLevel.parse(2));
		assertEquals(ReleaseLevel.STABLE, ReleaseLevel.parse(3));
	}
}
