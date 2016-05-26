package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.MergeRequest;
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

	@Test
	public void mergeRequestStatusValueCorrect() {

		assertEquals(0, MergeRequest.Status.OPEN.getValue().intValue());
		assertEquals(1, MergeRequest.Status.CLOSED.getValue().intValue());
		assertEquals(2, MergeRequest.Status.IGNORED.getValue().intValue());

	}

	@Test
	public void mergeRequestStatusParsedCorrectly() {
		assertEquals(MergeRequest.Status.OPEN, MergeRequest.Status.parse(0));
		assertEquals(MergeRequest.Status.CLOSED, MergeRequest.Status.parse(1));
		assertEquals(MergeRequest.Status.IGNORED, MergeRequest.Status.parse(2));
	}

}
