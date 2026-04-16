package com.ecommerce.cart.entity.redis;

import org.springframework.data.annotation.Id;

import com.ecommerce.cart.dto.response.ProductDTOResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="t_cartItems")
public class CartItem {

	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cart;
	
	@Column(name="c_pruduct")
	private ProductDTOResponse product;
	
	@Column(name="c_quantity")
	private Integer qty;
}
