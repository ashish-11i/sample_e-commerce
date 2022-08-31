package com.website.ecommerce.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.website.ecommerce.dao.ProductRepo;
import com.website.ecommerce.dao.UserRepo;
import com.website.ecommerce.dto.ProductDto;
import com.website.ecommerce.dto.UpdateUserRequest;
import com.website.ecommerce.dto.UserDto;
import com.website.ecommerce.entities.Product;
import com.website.ecommerce.entities.Role;
import com.website.ecommerce.entities.User;
import com.website.ecommerce.exceptions.ResourceAlreadyExistException;
import com.website.ecommerce.exceptions.ResourceNotFoundException;
import com.website.ecommerce.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto registerNewUser(UserDto userDto, Role role) {
		String username = userDto.getUsername();
		
		if(userRepo.findUserByUsername(username)!=null) {
			throw new ResourceAlreadyExistException("User", "username", username);
		}
		
		String email = userDto.getEmail();
		if(userRepo.findByEmail(email).isPresent()) {
			throw new ResourceAlreadyExistException("User", "email", email);
		}
		
		User user = modelMapper.map(userDto, User.class);
		user.getRoles().add(role);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User createdUser = userRepo.save(user);
		return modelMapper.map(createdUser, UserDto.class);
	}


	@Override
	public UserDto findUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userID", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> findAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto updateUser(Integer userId, UpdateUserRequest updateUserRequest) {
		User existUser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userID", userId));
		existUser.setLastName(updateUserRequest.getLastName());
		existUser.setEmail(updateUserRequest.getEmail());
		existUser.setPassword(updateUserRequest.getPassword());
		return this.modelMapper.map(existUser, UserDto.class);
	}


	@Override
	public List<ProductDto> findAllProducts() {
		List<Product> products = productRepo.findAll();
		List<ProductDto> productDtos = products.stream().map(product->this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}

}
