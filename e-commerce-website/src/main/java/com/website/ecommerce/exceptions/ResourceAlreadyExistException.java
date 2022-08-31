package com.website.ecommerce.exceptions;

public class ResourceAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceAlreadyExistException(String resourceName, String fieldName, Object fielValue){
		super(String.format("%s already exist with %s %s",resourceName, fieldName, fielValue));
	}

}
