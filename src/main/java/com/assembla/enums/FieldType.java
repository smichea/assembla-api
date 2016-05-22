package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FieldType implements ValuedEnum<String> {
	TEXT("text"), 
	NUMERIC("numeric"), 
	TEAM_LIST("team list"), 
	LIST("list"), 
	DATE("date");

	private String value;

	FieldType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static FieldType parse(String value) {
		return ValuedEnum.parse(value.toLowerCase(), FieldType.values());
	}

}
