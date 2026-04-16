package com.ecommerce.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.cart.entity.jpa.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

}