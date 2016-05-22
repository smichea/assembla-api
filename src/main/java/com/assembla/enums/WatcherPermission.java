package com.assembla.enums;


public enum WatcherPermission implements IntValuedEnum {
	READ(1),
	EDIT(2),
	ALL(3);

	private int value;

	private WatcherPermission(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	public static WatcherPermission parse(int value) {
		return ValuedEnum.parse(value, WatcherPermission.values());
	}

}
