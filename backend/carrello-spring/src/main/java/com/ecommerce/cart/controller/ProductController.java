package com.ecommerce.cart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart.dto.ProductDTO;
import com.ecommerce.cart.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Prodotti Carrello Abstract", description = "Project work Abstract 2026")
public class ProductController {

	
	private final ProductService service;
	
	@Operation(summary = "Recupera tutti i prodotti")
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		log.info("return all products");
		
		return ResponseEntity.ok(service.findAll());
	}
	
	@Operation(summary = "Recupera un prodotto per ID")
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
		log.info("get product by id");
		
		return ResponseEntity.ok(service.findById(id));
	}
	
	@Operation(summary = "Crea un prodotto")
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
		log.info("create product");
		
		return ResponseEntity.ok(service.create(dto));
	}
	
	@Operation(summary = "Aggiorna un prodotto per ID")
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO dto, @PathVariable Long id){
		log.info("update product");
		return ResponseEntity.ok(service.update(dto,id));
		
	}
	
	@Operation(summary = "Elimina un prodotto per ID")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		log.info("delete product");
		
		service.delete(id);
	}
	
	/*@GetMapping
	public ResponseEntity<List<ProductDTORequest>> getProductByCategory(@PathVariable Long categoryId){
		log.info("get products by category");
		
		return ResponseEntity.ok(service.s)
	}*/
	
}
