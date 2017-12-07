package com.example.exceptions;

public class BillingDetailsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillingDetailsException(String message) {
		super(message);
	}

	public BillingDetailsException(Throwable throwable) {
		super(throwable);
	}
}
