package test.com.assembla.serializer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.serialization.ListToStringSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;

@RunWith(MockitoJUnitRunner.class)
public class ListToStringSerializerTest {
	private ListToStringSerializer listSerializer = new ListToStringSerializer();

	@Mock
	private JsonGenerator generator;
	@Mock
	private SerializerProvider provider;

	@Captor
	private ArgumentCaptor<String> keyCapture;

	@Test
	public void customFieldSerializerAddsUnderscore() throws JsonProcessingException, IOException {
		List<String> input = Arrays.asList("test@test.com", "test2@test.com");
		listSerializer.serialize(input, generator, provider);
		Mockito.verify(generator).writeString(keyCapture.capture());
		String serialized = keyCapture.getValue();

		assertEquals("test@test.com,test2@test.com", serialized);
	}

}
