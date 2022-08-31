package com.website.ecommerce.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
	private boolean status;
	private HttpStatus statusCode;
	private Object result;
	private Error error;
	private String message;
}
