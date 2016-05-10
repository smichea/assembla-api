package com.assembla;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PermissionType {
	DEVELOPMENT(0), SUPPORT_PRIVATE(1), SUPPORT_PUBLIC(2);

	private int value;

	PermissionType(int value) {
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}
	@JsonCreator
	public static PermissionType parse(int permission) {
		return Arrays
				.stream(PermissionType.values())
				.filter(e -> e.value == permission)
				.findFirst()
				.orElseThrow(
						() -> new IllegalArgumentException(String.format("Illegal permission value specified : %d")));
	}

}