package com.website.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.ecommerce.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
