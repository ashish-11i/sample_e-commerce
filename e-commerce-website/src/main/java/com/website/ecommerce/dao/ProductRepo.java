package com.website.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.ecommerce.entities.Product;
import com.website.ecommerce.entities.User;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//	@Query("select p.productId, p.brandName, p.description, p.productName from Product p where user_id=?1")
	List<Product> findByUser(User user);

}
