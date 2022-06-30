package com.zensar.exception;

public class ProductException extends RuntimeException {

	private String message;

	public ProductException() {
		super();
	}

	public ProductException(String message) {
		super(message);
		this.message = message;
	}

}
