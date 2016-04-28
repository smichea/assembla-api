package com.assembla.utils;

public final class ObjectUtils {

	/**
	 * Check if an object is null and throw an IllegalArgumentException with
	 * supplied message same as Objects.notNull but throws a different exception
	 * 
	 * @param object
	 * @param message
	 */
	public static <T> T notNull(T object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
		return object;
	}

	private ObjectUtils() {
	}
}
