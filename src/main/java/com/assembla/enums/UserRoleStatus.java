package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRoleStatus implements IntValuedEnum {
	INVITED(1), 
	ACCEPTED(2), 
	REMOVED(3);
	
	private int value;

	UserRoleStatus(int value){
		this.value = value;
	}

	@Override
	@JsonValue
	public Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static UserRoleStatus parse(int value) {
		return ValuedEnum.parse(value, UserRoleStatus.values());
	}

}
