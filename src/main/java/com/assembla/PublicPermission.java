package com.assembla;

import com.assembla.enums.IntValuedEnum;
import com.assembla.enums.ValuedEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PublicPermission implements IntValuedEnum {
	NONE(0), READ(1), WRITE(2);

	private int value;

	PublicPermission(int value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static PublicPermission parse(int value) {
		return ValuedEnum.parse(value, PublicPermission.values());
	}

}
