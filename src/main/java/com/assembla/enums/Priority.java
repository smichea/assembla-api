package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority implements IntValuedEnum {
	HIGHEST(1), 
	HIGH(2), 
	NORMAL(3), 
	LOW(4), 
	LOWEST(5);

	private int value;

	Priority(int value) {
		this.value = value;
	}

	@JsonValue
	@Override
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static Priority parse(int priority) {
		return ValuedEnum.parse(priority, Priority.values());
	}
}
