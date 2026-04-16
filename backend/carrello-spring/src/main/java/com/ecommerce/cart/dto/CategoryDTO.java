package com.ecommerce.cart.dto;

import java.util.List;

public record CategoryDTO(
	    Long id_cat, 
	    String name,
	    String description
	    //List <ProductDTO> products
	) {}