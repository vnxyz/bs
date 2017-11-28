package com.example.exceptions;

public class ItemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemException(String message) {
		super(message);
	}

	public ItemException(Throwable throwable) {
		super(throwable);
	}
}
