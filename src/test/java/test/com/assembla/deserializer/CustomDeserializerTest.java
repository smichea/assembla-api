package test.com.assembla.deserializer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.serialization.StringToListDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

@RunWith(MockitoJUnitRunner.class)
public class CustomDeserializerTest {

	private StringToListDeserializer sToASerializer = new StringToListDeserializer();

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private JsonParser parser;
	@Mock
	private DeserializationContext ctxt;
	@Mock
	private JsonNode node;

	@Test
	public void stringToListSerializer() throws JsonProcessingException, IOException {
		String tabs = "---\n- Wiki\n- Tickets\n- Milestones\n- Source/SVN\n- Team\n";
		
		List<String> expected = new ArrayList<>();
		expected.add("---");
		expected.add("- Wiki");
		expected.add("- Tickets");
		expected.add("- Milestones");
		expected.add("- Source/SVN");
		expected.add("- Team");

		when(node.asText()).thenReturn(tabs);
		when(parser.getCodec().readTree(parser)).thenReturn(node);
		List<String> actual = sToASerializer.deserialize(parser, ctxt);

		assertEquals(expected, actual);
	}

	@Test
	public void stringToListEmptyStringEmptyList() throws JsonProcessingException, IOException {
		when(node.asText()).thenReturn("");
		when(parser.getCodec().readTree(parser)).thenReturn(node);
		List<String> actual = sToASerializer.deserialize(parser, ctxt);
		assertEquals(Collections.emptyList(), actual);
	}
}
