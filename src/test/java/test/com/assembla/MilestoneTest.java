package test.com.assembla;


import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.enums.PlannerType;
import com.assembla.enums.ReleaseLevel;

public class MilestoneTest {

	@Test
	public void plannerTypeValueCorrect() {
		assertEquals(0, PlannerType.NONE.getValue().intValue());
		assertEquals(1, PlannerType.BACKLOG.getValue().intValue());
		assertEquals(2, PlannerType.CURRENT.getValue().intValue());
	}

	@Test
	public void plannerTypeByValueCorrect() {
		assertEquals(PlannerType.NONE, PlannerType.parse(0));
		assertEquals(PlannerType.BACKLOG, PlannerType.parse(1));
		assertEquals(PlannerType.CURRENT, PlannerType.parse(2));
	}
	
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
