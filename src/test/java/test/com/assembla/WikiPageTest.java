package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.WikiPage.WikiFormat;

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

}
