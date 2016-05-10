package com.assembla;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
	HIGHEST(1), HIGH(2), NORMAL(3), LOW(4), LOWEST(5);

	private int value;

	@JsonValue
	public int getValue() {
		return value;
	}

	Priority(int value) {
		this.value = value;
	}

	@JsonCreator
	public static Priority parse(int priority) {
		return Arrays.stream(Priority.values()).filter(e -> e.value == priority).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Illegal priority value specified"));
	}
}