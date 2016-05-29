package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.SourceSymbolType;

public class MergeRequestTest {

	@Test
	public void sourceSymbolType() {
		assertEquals(1, SourceSymbolType.BRANCH.getValue().intValue());
		assertEquals(2, SourceSymbolType.TAG.getValue().intValue());
		assertEquals(3, SourceSymbolType.REVISION.getValue().intValue());
	}

	@Test
	public void sourceSymbolFromValueCorrect() {

		assertEquals(SourceSymbolType.BRANCH, SourceSymbolType.parse(1));
		assertEquals(SourceSymbolType.TAG, SourceSymbolType.parse(2));
		assertEquals(SourceSymbolType.REVISION, SourceSymbolType.parse(3));
	}

}
