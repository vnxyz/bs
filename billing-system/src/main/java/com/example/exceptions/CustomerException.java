package com.example.exceptions;

public class CustomerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable throwable) {
		super(throwable);
	}
}
