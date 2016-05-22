package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TagStatus implements IntValuedEnum {
	PROPOSED(1), 
	ACTIVE(2), 
	HIDDEN(4);

	private int value;

	TagStatus(int value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public  Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static TagStatus parse(int value) {
		return ValuedEnum.parse(value, TagStatus.values());
	}

}
