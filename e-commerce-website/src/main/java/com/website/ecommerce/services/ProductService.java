package com.website.ecommerce.services;

import java.util.List;

import com.website.ecommerce.dto.ProductDto;

public interface ProductService {
	ProductDto addProduct(Integer user_id, ProductDto productDto);
	ProductDto updateProduct(Integer user_id, Integer id, ProductDto productDto);
	ProductDto deleteProduct(Integer user_id, Integer id);
	ProductDto getProductById(Integer user_id, Integer id);
	List<ProductDto> getProducts(Integer user_id);
}
