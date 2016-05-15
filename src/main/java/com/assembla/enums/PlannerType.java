package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

public enum PlannerType implements IntValuedEnum {
	NONE(0), 
	BACKLOG(1), 
	CURRENT(2);

	private int value;

	PlannerType(int value){
		this.value = value;
	}

	@Override
	@JsonGetter
	public Integer getValue() {
		return this.value;
	}

	@JsonCreator
	public static PlannerType parse(int value) {
		return ValuedEnum.parse(value, PlannerType.values());
	}
	
}