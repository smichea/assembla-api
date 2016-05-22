package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PermissionType implements IntValuedEnum {
	DEVELOPMENT(0), 
	SUPPORT_PRIVATE(1), 
	SUPPORT_PUBLIC(2);

	private int value;

	PermissionType(int value) {
		this.value = value;
	}

	@JsonValue
	@Override
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static PermissionType parse(int permission) {
		return ValuedEnum.parse(permission, PermissionType.values());
	}

}
