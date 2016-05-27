package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.WikiPage.WikiFormat;
import com.assembla.WikiPage.WikiStatus;

public class WikiPageTest {

	@Test
	public void wikiFormatTest() {
		assertEquals(2, WikiFormat.TEXT_FILE.getValue().intValue());
		assertEquals(3, WikiFormat.HTML.getValue().intValue());
	}
	
	@Test
	public void wikiFormatParseTest() {
		assertEquals(WikiFormat.TEXT_FILE, WikiFormat.parse(2));
		assertEquals(WikiFormat.HTML, WikiFormat.parse(3));
	}
	
	@Test
	public void wikiStatusTest() {
		assertEquals(0, WikiStatus.PRIVATE.getValue().intValue());
		assertEquals(1, WikiStatus.ACTIVE.getValue().intValue());
		assertEquals(2, WikiStatus.ARCHIVED.getValue().intValue());
	}
	
	@Test
	public void wikiStatusParseTest() {
		assertEquals(WikiStatus.PRIVATE, WikiStatus.parse(0));
		assertEquals(WikiStatus.ACTIVE, WikiStatus.parse(1));
		assertEquals(WikiStatus.ARCHIVED, WikiStatus.parse(2));
	}
}
