package com.ecommerce.cart.controller;

import com.ecommerce.cart.dto.request.AddItemCartRequest;
import com.ecommerce.cart.dto.request.UpdateQtyRequest;
import com.ecommerce.cart.dto.response.ApiResponse;
import com.ecommerce.cart.dto.response.CartResponse;
import com.ecommerce.cart.service.CartService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ApiResponse<CartResponse> getCart(@AuthenticationPrincipal UserDetails userDetails) {
    	log.info("GET cart - userId={}", userDetails.getUsername());
    	
        return ApiResponse.success("Cart retrieved successfully", cartService.getCart(userDetails.getUsername()));
    }

	@PostMapping("/additems")
	public ApiResponse<CartResponse> addItem(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody AddItemCartRequest request) {
	    log.info("ADD item - userId={}, productId={}, quantity={}", userDetails.getUsername(), request.productId(), request.quantity());
		
		return ApiResponse.success("Item added to cart", cartService.addItem(userDetails.getUsername(), request));
	}

	@PutMapping("/updateitems")
	public ApiResponse<CartResponse> updateItemQuantity(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody UpdateQtyRequest request) {		
	    log.info("UPDATE item qty - userId={}, productId={}, quantity={}", userDetails.getUsername(), request.productId(), request.quantity());
		
		return ApiResponse.success("Cart item updated", cartService.updateItemQuantity(userDetails.getUsername(), request));
	}

	@DeleteMapping("/{productId}")
	public ApiResponse<CartResponse> removeItem(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long productId) {	
		log.info("REMOVE item - userId={}, productId={}", userDetails.getUsername(), productId);
		
		return ApiResponse.success("Item removed from cart", cartService.removeItem(userDetails.getUsername(), productId));
	}

    @DeleteMapping
    public ApiResponse<Void> clearCart(@AuthenticationPrincipal UserDetails userDetails) {
    	log.warn("CLEAR cart - userId={}", userDetails.getUsername());
    	
        cartService.clearCart(userDetails.getUsername());
        return ApiResponse.success("Cart cleared", null);
    }
}
