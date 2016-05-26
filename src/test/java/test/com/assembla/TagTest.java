package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.Tag.TagStatus;

public class TagTest {
	@Test
	public void tagStatusValueCorrect() {
		assertEquals(1, TagStatus.PROPOSED.getValue().intValue());
		assertEquals(2, TagStatus.ACTIVE.getValue().intValue());
		assertEquals(4, TagStatus.HIDDEN.getValue().intValue());
	}

	@Test
	public void tagStatusByValueCorrect() {
		assertEquals(TagStatus.PROPOSED, TagStatus.parse(1));
		assertEquals(TagStatus.ACTIVE, TagStatus.parse(2));
		assertEquals(TagStatus.HIDDEN, TagStatus.parse(4));
	}
}
