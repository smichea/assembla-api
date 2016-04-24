package com.assembla.client;
import java.util.Optional;

public class AssemblaResponse {

	private final Object value;
	private final Class<?> type;

	public AssemblaResponse(Object value, Class<?> type) {
		this.value = value;
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}

	@SuppressWarnings("unchecked")
	public <E> Optional<E> getValue() {
		return (Optional<E>) Optional.ofNullable(value);
	}

}
