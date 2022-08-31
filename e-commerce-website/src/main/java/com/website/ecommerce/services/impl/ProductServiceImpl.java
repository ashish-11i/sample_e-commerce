package com.website.ecommerce.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ecommerce.dao.ProductRepo;
import com.website.ecommerce.dao.UserRepo;
import com.website.ecommerce.dto.ProductDto;
import com.website.ecommerce.entities.Product;
import com.website.ecommerce.entities.User;
import com.website.ecommerce.exceptions.ResourceNotFoundException;
import com.website.ecommerce.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto addProduct(Integer user_id, ProductDto productDto) {
		User user = userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
		
		Product product = modelMapper.map(productDto, Product.class);
		product.setUser(user);
		Product savedProduct = productRepo.save(product);
		
		return this.modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(Integer user_id, Integer id, ProductDto productDto) {
		User user = userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
		Product product = productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "product_id", id));
		product.setProductName(productDto.getProductName());
		product.setBrandName(productDto.getBrandName());
		product.setDescription(product.getDescription());
		product.setUser(user);
		
		Product savedProduct =  productRepo.save(product);
		return this.modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto deleteProduct(Integer user_id, Integer id) {
		userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
		Product product = productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "product_id", id));
		productRepo.delete(product);
		return this.modelMapper.map(product, ProductDto.class);
	}

	@Override
	public ProductDto getProductById(Integer user_id, Integer id) {
		userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
		Product product = productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "product_id", id));
		return this.modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getProducts(Integer user_id) {
		User user = userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "user_id", user_id));
		List<Product> products =  productRepo.findByUser(user);
		List<ProductDto> productDtos = products.stream().map(product->this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}
	

}
