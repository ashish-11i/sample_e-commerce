package com.website.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private Integer productId;
	private String productName;
	private String brandName;
	private String description;
}
