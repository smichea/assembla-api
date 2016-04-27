package com.assembla.client;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Encapsulate request parameters for Assembla api
 * 
 * @author matthewsladen
 *
 */
public class AssemblaRequest {

	private final Class<?> type;
	private final String uri;
	private final Map<String, Object> parameters = new LinkedHashMap<>();
	private Object body;

	public AssemblaRequest(String uri, Class<?> type) {
		this.uri = uri;
		this.type = type;
	}
	
	public AssemblaRequest(String uri) {
		this(uri, null);
	}
	
	public AssemblaRequest withBody(Object body) {
		this.body = body;
		return this;
	}

	/**
	 * Return type that this request will return
	 * @return Optional wrapped type whcih this request will return
	 */
	public Optional<Class<?>> getType() {
		return Optional.ofNullable(type);
	}

	public Map<String, Object> getParameters() {
		return Collections.unmodifiableMap(parameters);
	}

	public String getUri() {
		return uri;
	}

	public AssemblaRequest addParam(String key, Object value) {
		this.parameters.put(key, value);
		return this;
	}

	protected String buildParameters() {
		Set<String> keys = this.parameters.keySet();
		if (keys.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;

		for (String s : keys) {
			if (isFirst) {
				sb.append("?");
				isFirst = false;
			} else {
				sb.append("&");
			}
			sb.append(s).append("=").append(parameters.get(s));
		}

		return sb.toString();
	}

	public final String getFullURI() {
		return this.uri + buildParameters();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AssemblaRequest other = (AssemblaRequest) obj;
		if (body == null) {
			if (other.body != null) {
				return false;
			}
		} else if (!body.equals(other.body)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (getFullURI() == null) {
			if (other.getFullURI() != null) {
				return false;
			}
		} else if (!getFullURI().equals(other.getFullURI())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssemblaRequest [type=");
		builder.append(type);
		builder.append(", getFullURI()=");
		builder.append(getFullURI());
		builder.append("]");
		return builder.toString();
	}

	public Optional<Object> getBody() {
		return Optional.ofNullable(body);
	}

}
