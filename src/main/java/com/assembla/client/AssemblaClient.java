package com.assembla.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Optional;

import com.assembla.exception.AssemblaAPIException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AssemblaClient  {
	/**
	 * API Key
	 */
	protected final String apiKey;
	/**
	 * API Password
	 */
	protected final String apiPassword;
	/**
	 * Client for making HTTP requests
	 */
	protected final javax.ws.rs.client.Client client;

	/**
	 * Json Object Mapper
	 */
	protected final ObjectMapper mapper;
	/**
	 * URL for api calls
	 */
	protected final String baseURL;

	/**
	 * MediaType for JSON media type
	 */
	//protected static final MediaType JSON = MediaType.parse(AssemblaConstants.JSON_MEDIA_TYPE);
	/**
	 * Media type for file uploads
	 */
	//private static final MediaType FILE_TYPE = MediaType.parse("");
	/**
	 * Create new Assembla client. Key and password will be used to authenticate
	 * requests
	 * 
	 * @param key
	 *            User's API
	 * @param password
	 *            User's API password
	 */
	public AssemblaClient(String key, String password) {
		this.apiKey = key;
		this.apiPassword = password;
		client = ClientBuilder.newClient();
		mapper = new ObjectMapper();
		baseURL = AssemblaConstants.URL;
		configureMapper();
	}

	public String getKey() {
		return apiKey;
	}

	public String getBaseURL() {
		return baseURL;
	}

	 private Builder getRequestBuilder(AssemblaRequest request){
		WebTarget webTarget = client.target(this.getBaseURL()).path(request.getFullURI());
		Builder rb = webTarget.request(MediaType.APPLICATION_JSON);
		rb.header(AssemblaConstants.HEADER_API_KEY, this.apiKey);
		rb.header(AssemblaConstants.HEADER_API_SECRET, this.apiPassword);
		return rb;
	 }


	public AssemblaResponse get(AssemblaRequest request) {
		Builder rb = getRequestBuilder(request);
		return doRequest(rb.buildGet(),request);
	}

	public AssemblaResponse put(AssemblaRequest request) {
		Builder rb = getRequestBuilder(request);
		Invocation invocation = null;
		if(request.getBody().isEmpty()){
			invocation = rb.buildPut(Entity.json(null));
		} else {
			invocation = rb.buildPut(Entity.json(request.getBody().get()));
		}
		return doRequest(invocation,request);
	}

	public AssemblaResponse post(AssemblaRequest request) {
		Builder rb = getRequestBuilder(request);
		Invocation invocation = null;
		if(request.getBody().isEmpty()){
			invocation = rb.buildPost(Entity.json(null));
		} else {
			invocation = rb.buildPost(Entity.json(request.getBody().get()));
		}
		return doRequest(invocation,request);
	}

	public AssemblaResponse delete(AssemblaRequest request) {
		Builder rb = getRequestBuilder(request);
		return doRequest(rb.buildDelete(),request);
	}

	/*
	public AssemblaResponse post(UploadAssemblaRequest request) {
		
		MultipartBuilder multiPartBuilder = buildMultipartFormRequest(request);
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		builder.post(multiPartBuilder.build());
		return doRequest(builder.build(), request);

	}
	
	public AssemblaResponse put(UploadAssemblaRequest request) {
		MultipartBuilder multiPartBuilder = buildMultipartFormRequest(request);
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		builder.put(multiPartBuilder.build());
		return doRequest(builder.build(), request);
	}

	private MultipartBuilder buildMultipartFormRequest(UploadAssemblaRequest request) {
		UploadableItem<?> uploadableItem = request.getUploadableItem();

		RequestBody fileBody = RequestBody.create(FILE_TYPE, uploadableItem.fIle());
		String name = String.format(AssemblaConstants.UPLOAD_NAME_FORMAT, uploadableItem.namespace());
		MultipartBuilder multiPartBuilder = new MultipartBuilder()
		.type(MultipartBuilder.FORM)
		.addFormDataPart(name, uploadableItem.fIle().getName(), fileBody);
		uploadableItem.location().ifPresent(e -> multiPartBuilder.addFormDataPart(AssemblaConstants.UPLOAD_LOCATION, e));
		return multiPartBuilder;
	}
*/
	protected AssemblaResponse doRequest(Invocation invocation, AssemblaRequest request) {
		Optional<Class<?>> type = request.getType();
		Response response=null;
		try {
			response = invocation.invoke();
			// Not a success - notify caller via exception
			if (response.getStatus() != Response.Status.OK.getStatusCode()){
				if( response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
					return new AssemblaResponse();
				} else {
					throw new AssemblaAPIException(String.format("Error making request to [%s, %s], message [%d, %s]",
					invocation.toString(), request.getFullURI(), response.getStatus(), response.getStatusInfo().getReasonPhrase()));	
				}
			}
			// Otherwise we can return the response in requested format
			final Reader charStream = new InputStreamReader(response.readEntity(InputStream.class));
			return new AssemblaResponse(mapper.readValue(charStream, type.get()), type.get());
		} catch (IOException e) {
			throw new AssemblaAPIException("Error making request", e);
		} finally {
			if(response!=null){
				response.close();
			}
		}
	}

	private void configureMapper() {
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.findAndRegisterModules();
	}

}
