package com.example.exceptions;

public class ProductException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductException(String message) {
		super(message);
	}

	public ProductException(Throwable throwable) {
		super(throwable);
	}
}
