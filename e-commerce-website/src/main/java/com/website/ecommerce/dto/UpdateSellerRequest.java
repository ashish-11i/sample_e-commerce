package com.website.ecommerce.dto;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSellerRequest {
	private String lastName;
	@Pattern(regexp = "^[a-zA-Z]+([0-9]+)?[\\.]?([a-zA-Z0-9]+)?[\\@][a-zA-Z]+[\\.][a-zA-Z]{2,3}$")
	private String email;
	private String password;
}
