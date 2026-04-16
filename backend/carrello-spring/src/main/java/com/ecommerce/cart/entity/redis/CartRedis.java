package com.ecommerce.cart.entity.redis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("cart")
public class CartRedis implements Serializable {

    @Id
    private String id;

    @Builder.Default
    private List<CartItemRedis> items = new ArrayList<>();

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    @TimeToLive
    private Long ttl; 
}
