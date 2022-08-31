package com.website.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.website.ecommerce.entities.User;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username = ?1")
	User findUserByUsername(String username);
	Optional<User> findByEmail(String email);
}
