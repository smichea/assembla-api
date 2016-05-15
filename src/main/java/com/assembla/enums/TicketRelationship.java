package com.assembla.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketRelationship implements IntValuedEnum {
	PARENT(0), 
	CHILD(1), 
	RELATED(2), 
	DUPLICATE(3), 
	SIBLING(4), 
	STORY(5), 
	SUBTASK(6), 
	DEPENDANT(7),
	BLOCK(8); 
	
	private int value;

	TicketRelationship(int value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public Integer getValue() {
		return value;
	}

	@JsonCreator
	public static TicketRelationship parse(int value) {
		return ValuedEnum.parse(value, TicketRelationship.values());
	}

}