package com.example.exceptions;

public class SupplierException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupplierException(String message) {
		super(message);
	}

	public SupplierException(Throwable throwable) {
		super(throwable);
	}
}
