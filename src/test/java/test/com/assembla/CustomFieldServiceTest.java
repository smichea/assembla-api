package test.com.assembla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.assembla.CustomField;
import com.assembla.client.AssemblaRequest;
import com.assembla.client.AssemblaResponse;
import com.assembla.exception.AssemblaAPIException;
import com.assembla.service.CustomFieldService;

@RunWith(MockitoJUnitRunner.class)
public class CustomFieldServiceTest extends ServiceTest {

	private CustomFieldService customFieldService;

	@Before
	public void setup() {
		customFieldService = new CustomFieldService(super.assemblaClient, TEST_SPACE_ID);
	}

	@Test
	public void getCustomFieldsTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new CustomField[10], CustomField[].class));

		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_fields.json",
				CustomField[].class);

		List<CustomField> customFields = customFieldService.getAll();
		assertNotNull("Getting all custom fields should never return null", customFields);
		Mockito.verify(assemblaClient).doGet(request);
		assertEquals("Custom fields should be size of the list returned in mock request", 10, customFields.size());
	}

	@Test
	public void getCustomFieldByIdTest() {
		when(assemblaClient.doGet(any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(new CustomField(), CustomField.class));
		int id = 100;
		CustomField customField = customFieldService.get(id);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_fields/100.json",
				CustomField.class);
		verify(assemblaClient).doGet(request);
		assertNotNull(customField);
	}

	@Test
	public void createCustomFieldSuccessTest() {
		CustomField expectedValue = new CustomField();
		when(assemblaClient.doPost(Matchers.any(AssemblaRequest.class))).thenReturn(
				new AssemblaResponse(expectedValue, CustomField.class));

		CustomField customFieldToCreate = new CustomField();
		;
		customFieldToCreate.setTitle("Test title");
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_fields.json", CustomField.class);
		request.withBody(customFieldToCreate);

		CustomField customField = customFieldService.create(customFieldToCreate);
		verify(assemblaClient).doPost(request);
		assertNotNull("Created custom field is null", customField);
		assertEquals("Ticket not the same as one returned", expectedValue, customField);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createCustomFieldBadArgTest() {
		customFieldService.create(null);
	}

	@Test
	public void createCustomFieldFailTest() {
		when(assemblaClient.doPost(Matchers.any(AssemblaRequest.class))).thenThrow(
				new AssemblaAPIException("Error making request"));
		CustomField customField = customFieldService.create(new CustomField());
		assertNull("CustomField should be null", customField);
	}

	@Test
	public void updateCustomFieldTest() {
		when(assemblaClient.doPut(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		CustomField toUpdate = new CustomField();
		toUpdate.setId(100);
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_fields/100.json");
		request.withBody(toUpdate);
		customFieldService.update(toUpdate);
		verify(assemblaClient).doPut(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateCustomFieldBadArgTest() {
		customFieldService.update(null);
	}
	
	@Test
	public void deleteCustomFieldTest() {
		when(assemblaClient.doDelete(any(AssemblaRequest.class))).thenReturn(new AssemblaResponse());
		AssemblaRequest request = new AssemblaRequest("/spaces/test_space_id/tickets/custom_fields/100.json");
		
		CustomField toDelete = new CustomField();
		toDelete.setId(100);
		
		customFieldService.delete(toDelete);
		verify(assemblaClient).doDelete(request);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteBadArgTest() {
		customFieldService.delete(null);
	}

}
