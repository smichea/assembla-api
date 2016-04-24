package com.assembla.exception;

public class AssemblaAPIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int statusCode;

	public AssemblaAPIException(String message) {
		super(message);
	}

	public AssemblaAPIException(String message, int status) {
		super(message);
		this.statusCode = status;
	}

	public AssemblaAPIException(String string, Throwable e) {
		super(string, e);
	}

	public int getStatusCode() {
		return statusCode;
	}

}
