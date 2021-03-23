package com.paypal.bfs.test.employeeserv.exception;

public class RequiredFieldsMissingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RequiredFieldsMissingException(String message) {
		super(message);
	}
}
