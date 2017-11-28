package com.example.exceptions;

public class CompanyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyException(String message) {
		super(message);
	}

	public CompanyException(Throwable throwable) {
		super(throwable);
	}
}
