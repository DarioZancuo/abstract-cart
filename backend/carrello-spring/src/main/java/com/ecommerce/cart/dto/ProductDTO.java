package com.ecommerce.cart.dto;

import java.math.BigDecimal;

import com.ecommerce.cart.entity.jpa.Category;

public record ProductDTO(
	    Long id_prod, 
	    String name, 
	    String description,
	    BigDecimal price,
	    Long id_cat,
	    String categoryName
	    
	) {}