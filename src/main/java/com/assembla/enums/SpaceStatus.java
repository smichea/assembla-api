package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SpaceStatus implements IntValuedEnum {
	PROPOSED(0), 
	ACTIVE(1), 
	ARCHIVED(2), 
	SHARED(4);

	private int value;

	private SpaceStatus(int value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static SpaceStatus parse(int value) {
		return ValuedEnum.parse(value, SpaceStatus.values());
	}
}