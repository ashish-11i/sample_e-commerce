//package com.website.ecommerce.entities;
//
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class Seller {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer seller_id;
//	private String firstName;
//	private String lastName;
//	@Column(unique = true)
//	private String email;
//	
//	@Column(unique = true)
//	private String username;
//	private String password;
//	private LocalDate dob;
//}
