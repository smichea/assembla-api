package test.com.assembla;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assembla.CustomField.FieldType;

public class CustomFieldTest {
	@Test
	public void customFieldTypeValueCorrect() {
		assertEquals("text", FieldType.TEXT.getValue());
		assertEquals("numeric", FieldType.NUMERIC.getValue());
		assertEquals("team list", FieldType.TEAM_LIST.getValue());
		assertEquals("list", FieldType.LIST.getValue());
		assertEquals("date", FieldType.DATE.getValue());
	}

	@Test
	public void customFieldTypeByValueCorrect() {
		assertEquals(FieldType.TEXT, FieldType.parse("text"));
		assertEquals(FieldType.NUMERIC, FieldType.parse("numeric"));
		assertEquals(FieldType.TEAM_LIST, FieldType.parse("team list"));
		assertEquals(FieldType.LIST, FieldType.parse("list"));
		assertEquals(FieldType.DATE, FieldType.parse("date"));
	}

	@Test
	public void customFieldTypeByValueAnyCaseCorrect() {
		assertEquals(FieldType.TEXT, FieldType.parse("TEXT"));
		assertEquals(FieldType.TEXT, FieldType.parse("TExT"));

		assertEquals(FieldType.NUMERIC, FieldType.parse("numeRic"));
		assertEquals(FieldType.NUMERIC, FieldType.parse("NumeRic"));
		assertEquals(FieldType.TEAM_LIST, FieldType.parse("TEam list"));
		assertEquals(FieldType.TEAM_LIST, FieldType.parse("TEam LIST"));

		assertEquals(FieldType.LIST, FieldType.parse("liSt"));
		assertEquals(FieldType.LIST, FieldType.parse("LIST"));

		assertEquals(FieldType.DATE, FieldType.parse("dATe"));
		assertEquals(FieldType.DATE, FieldType.parse("Date"));
	}
}
