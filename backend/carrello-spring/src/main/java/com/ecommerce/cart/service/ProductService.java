package com.ecommerce.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.cart.dto.ProductDTO;
import com.ecommerce.cart.entity.jpa.Product;
import com.ecommerce.cart.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository repository;

	public List<ProductDTO> findAll() {
		List<Product> prodotti = repository.findAll();

		return prodotti.stream().map(this::convertToDTO).toList();
	};

	public ProductDTO findById(Long id) {
		return null;
	};

	public ProductDTO create(ProductDTO dto) {
		return null;
	};

	public ProductDTO update(ProductDTO dto, Long id) {
		return null;
	};

	public void delete(Long id) {

	};

	// Metodo helper per la conversione (o usa MapStruct in futuro)
	private ProductDTO convertToDTO(Product p) {
		var cat = p.getCategory();
		return new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(), cat.getId(), cat.getName());
	}
	// public List<ProductDTO> findByCategory(Long categoryId);

	// public List<ProductDTO> searchByName(String name);
}
