package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum State implements IntValuedEnum {
	CLOSED(0), 
	OPEN(1);

	private int value;

	State(int value) {
		this.value = value;
	}

	@JsonValue
	@Override
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static State parse(int state) {
		return ValuedEnum.parse(state, State.values());
	}

}
