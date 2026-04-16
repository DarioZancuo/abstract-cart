package com.ecommerce.cart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart.dto.CategoryDTO;
import com.ecommerce.cart.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
@Validated
@Tag(name = "Category Controller", description = "API per la gestione delle categorie")
public class CategoryController {

    private final CategoryService service;

    @Operation(
        summary = "Ottieni tutte le categorie",
        description = "Restituisce la lista completa di tutte le categorie presenti nel catalogo"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        log.info("return all categories");
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(
        summary = "Recupera una categoria per ID",
        description = "Restituisce i dettagli di una singola categoria tramite il suo identificativo"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable @Positive Long id) {
        log.info("get category by id: {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(
        summary = "Crea una nuova categoria",
        description = "Aggiunge una nuova categoria al sistema"
    )
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO dto) {
        log.info("create category");
        return ResponseEntity.ok(service.create(dto));
    }

    @Operation(
        summary = "Aggiorna una categoria esistente",
        description = "Modifica i dati di una categoria esistente tramite ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @Valid @RequestBody CategoryDTO dto,
            @PathVariable @Positive Long id) {
        log.info("update category: {}", id);
        return ResponseEntity.ok(service.update(dto, id));
    }

    @Operation(
        summary = "Elimina una categoria",
        description = "Rimuove una categoria dal sistema tramite il suo ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable @Positive Long id) {
        log.info("delete category: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
