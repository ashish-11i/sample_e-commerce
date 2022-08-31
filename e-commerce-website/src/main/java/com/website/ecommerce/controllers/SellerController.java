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
@RequestMapping("/api/seller")
public class SellerController {
	
	@Autowired
	private UserService sellerService;
	
//	@Autowired
//	private RoleRepo roleRepo;
//	
//	@PostMapping("/register")
//	ResponseEntity<ResponseModel> registerNewSeller(@Valid @RequestBody UserDto sellerDto) {
//		Role role = roleRepo.findById(AppConstants.SELLER_USER).get();
//		return new ResponseEntity<ResponseModel>(new ResponseModel(
//				true, HttpStatus.OK, sellerService.registerNewUser(sellerDto,role), null, "You have logedin successfully"), HttpStatus.CREATED);
//	}
	
	
	@GetMapping("/singleUser")
	ResponseEntity<ResponseModel> findSellerById(@RequestParam(name = "sellerId") Integer sellerId) {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, sellerService.findUserById(sellerId), null, "DB data fetched successfully"), HttpStatus.OK);
	}
	@GetMapping("/")
	ResponseEntity<ResponseModel> findAllSeller() {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, sellerService.findAllUser(), null, "DB data fetched successfully"), HttpStatus.OK);
	}
	@PostMapping("/update")
	ResponseEntity<ResponseModel> updateSeller(@RequestParam(name = "sellerId") Integer sellerId, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
		return new ResponseEntity<ResponseModel>(new ResponseModel(
				true, HttpStatus.OK, sellerService.updateUser(sellerId, updateUserRequest), null, "DB data updated successfully"), HttpStatus.OK);
	}

}
