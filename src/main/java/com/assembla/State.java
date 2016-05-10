package com.assembla;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum State {
	OPEN(0), CLOSED(1);

	private int value;

	State(int value) {
		this.value = value;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	@JsonCreator
	public static State parse(int state) {
		return Arrays.stream(State.values()).filter(e -> e.value == state).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Illegal permission state specified : %d")));
	}

}