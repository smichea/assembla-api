package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AttachableType implements ValuedEnum<String> {
	TICKET("Ticket"), 
	FLOW("Flow"), 
	MILESTONE("Milestone");

	private String value;

	private AttachableType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static AttachableType parse(String value) {
		return ValuedEnum.parse(value, AttachableType.values());
	}

}
