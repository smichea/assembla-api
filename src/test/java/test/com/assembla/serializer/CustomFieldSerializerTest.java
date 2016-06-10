package test.com.assembla.serializer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.serialization.CustomFieldSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;


@RunWith(MockitoJUnitRunner.class)
public class CustomFieldSerializerTest {

	private CustomFieldSerializer customFieldSerializer = new CustomFieldSerializer();
	
	@Mock
	private JsonGenerator generator;
	@Mock
	private SerializerProvider provider;
	
	@Captor
	private ArgumentCaptor<String> keyCapture;

	@Test
	public void customFieldSerializerAddsUnderscore() throws JsonProcessingException, IOException {
		String input = "Key With Space";
		customFieldSerializer.serialize(input, generator, provider);
		Mockito.verify(generator).writeFieldName(keyCapture.capture());
		String serialized = keyCapture.getValue();
		
		assertEquals("Key_With_Space", serialized);
	}
	
}
