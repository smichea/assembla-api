package com.assembla;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HeirarchyType {
	NO_PLAN(0), SUB_TASK(1), STORY(2), EPIC(3);
	HeirarchyType(int value) {
		this.value = value;
	}

	public int value;

	@JsonValue
	public int getValue() {
		return value;
	}
	
	@JsonCreator
	public static HeirarchyType parse(int priority) {
		return Arrays.stream(HeirarchyType.values()).filter(e -> e.value == priority).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Illegal priority value specified"));
	}

}