package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HeirarchyType implements IntValuedEnum {
	NO_PLAN(0), 
	SUB_TASK(1), 
	STORY(2), 
	EPIC(3);

	public int value;

	HeirarchyType(int value) {
		this.value = value;
	}

	@JsonValue
	@Override
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static HeirarchyType parse(int value) {
		return ValuedEnum.parse(value, HeirarchyType.values());
	}

}
