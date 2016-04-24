package com.assembla.client;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

import org.apache.commons.io.IOUtils;

import com.assembla.exception.AssemblaAPIException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AssemblaClient  {

	/**
	 * API Key
	 */
	protected String apiKey;
	/**
	 * API Password
	 */
	protected String apiPassword;
	/**
	 * Current Space ID
	 */
	protected String spaceId;
	/**
	 * Client for making HTTP requests
	 */
	protected OkHttpClient client;

	/**
	 * Json Object Mapper
	 */
	protected ObjectMapper mapper;
	/**
	 * URL for api calls
	 */
	protected String baseURL;
	
	/**
	 * MediaType for JSON media type 
	 */
	protected static final MediaType JSON = MediaType.parse(AssemblaConstants.JSON_MEDIA_TYPE);

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
		client = new OkHttpClient();
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
	
	public String getSpaceId() {
		return spaceId;
	}
	
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}
	
	public AssemblaResponse doGet(AssemblaRequest request) {
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		return doRequest(builder.build(), request);
	}
	
	public AssemblaResponse doPut(AssemblaRequest request) {
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		builder.put(createJSONBody(request));
		return doRequest(builder.build(), request);
	}
	
	public AssemblaResponse doPost(AssemblaRequest request) {
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		builder.post(createJSONBody(request));
		return doRequest(builder.build(), request);
	}

	public AssemblaResponse doDelete(AssemblaRequest request) {
		Request.Builder builder = new Request.Builder();
		addCommon(request, builder);
		builder.delete();
		return doRequest(builder.build(), request);
	}

	protected AssemblaResponse doRequest(Request httpRequest, AssemblaRequest request) {
		Optional<Class<?>> type = request.getType();
		Reader charStream = null;
		try {
			Response response = client.newCall(httpRequest).execute();
			// Not a success - notify caller via exception
			if (!response.isSuccessful()) {
				throw new AssemblaAPIException("Error making request" , response.code());
			}
			// No content or request has not requested a type, so return null
			// object
			if (response.code() == AssemblaConstants.NO_CONTENT || !type.isPresent()) {
				return new AssemblaResponse(null, null);
			}
			// Otherwise we can return the response in requested format
			charStream = response.body().charStream();
			return new AssemblaResponse(mapper.readValue(charStream, type.get()), type.get());
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new AssemblaAPIException("Error making request" , e);
		} finally {
			IOUtils.closeQuietly(charStream);
		}
	}
	
	private void addCommon(AssemblaRequest request, Request.Builder rb) {
		rb.url(this.getBaseURL() + request.getFullURI());
		rb.header(AssemblaConstants.HEADER_API_KEY, this.apiKey);
		rb.header(AssemblaConstants.HEADER_API_SECRET, this.apiPassword);
	}

	private RequestBody createJSONBody(AssemblaRequest request) {
		return request.getBody()
				.map(e -> createRequest(e))
				.orElse(RequestBody.create(null, new byte[0]));
	}

	private RequestBody createRequest(Object request) {
		try {
			return RequestBody.create(JSON, mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AssemblaAPIException("Error creating JSON request body");
		}
	}

	private void configureMapper() {
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

}
