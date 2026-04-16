package com.ecommerce.cart.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record CartResponse(
        String username,
        List<CartItemResponse> items,
        Integer totalQuantity,
        BigDecimal totalPrice
) {}