package com.website.ecommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fielValue) {
		super(String.format("%s not found with %s %s", resourceName, fieldName, fielValue));
	}

}
