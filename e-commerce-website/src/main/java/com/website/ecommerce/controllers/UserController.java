package com.website.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.ecommerce.dto.UpdateUserRequest;
import com.website.ecommerce.response.ResponseModel;
import com.website.ecommerce.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping("/singleUser")
	ResponseEntity<ResponseModel> findUserById(@RequestParam(name = "userId") Integer userId) {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, userService.findUserById(userId), null, "DB data fetched successfully"), HttpStatus.OK);
	}
	@GetMapping("/")
	ResponseEntity<ResponseModel> findAllUser() {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, userService.findAllUser(), null, "DB data fetched successfully"), HttpStatus.OK);
	}
	@PostMapping("/update")
	ResponseEntity<ResponseModel> updateUser(@RequestParam(name = "userId") Integer userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, userService.updateUser(userId, updateUserRequest), null, "DB data updated successfully"), HttpStatus.OK);
	}
	
	
	@GetMapping("/product")
	ResponseEntity<ResponseModel> findProducts() {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, userService.findAllProducts(), null, "DB data fetched successfully"), HttpStatus.OK);
	
	}
	
}
