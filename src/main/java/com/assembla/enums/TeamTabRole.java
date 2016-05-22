package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TeamTabRole implements IntValuedEnum {
	ALL(0), 
	WATCHERS_AND_USERS(10), 
	MEMBERS_AND_USERS(50), 
	OWNER(90);

	private int value;

	TeamTabRole(int value) {
		this.value = value;
	}

	@JsonValue
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static TeamTabRole parse(int value) {
		return ValuedEnum.parse(value, TeamTabRole.values());
	}
	
}
