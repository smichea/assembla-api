package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReleaseLevel implements IntValuedEnum {
	ALPHA(1),
	BETA(2), 
	STABLE(3);

	private int value;

	ReleaseLevel(int value){
		this.value = value;
	}
	
	@Override
	@JsonValue
	public Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static ReleaseLevel parse(int value) {
		return ValuedEnum.parse(value, ReleaseLevel.values());
	}


}