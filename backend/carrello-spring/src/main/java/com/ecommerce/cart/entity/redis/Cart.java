package com.ecommerce.cart.entity.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.ecommerce.cart.entity.jpa.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("Cart")
public class Cart implements Serializable {
	//private static final long serialVersionUID = 5454516147072298642L;
	
	@Id
	private String id_cart;
	private User user; 
	private List<CartItem> products = new ArrayList<>();
}
