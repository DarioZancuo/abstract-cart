package com.ecommerce.cart.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDTO(

    Long id_prod,

    @NotBlank(message = "Il nome del prodotto non puo essere vuoto")
    @Size(min = 2, max = 100, message = "Il nome deve contenere tra 2 e 100 caratteri")
    String name,

    @NotBlank(message = "La descrizione non puo essere vuota")
    @Size(min = 5, max = 255, message = "La descrizione deve contenere tra 5 e 255 caratteri")
    String description,

    @NotNull(message = "Il prezzo e obbligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "Il prezzo deve essere maggiore di 0")
    @Digits(integer = 10, fraction = 2, message = "Il prezzo deve avere al massimo 10 cifre intere e 2 decimali")
    BigDecimal price,

    @NotBlank(message = "L'immagine del prodotto e obbligatoria")
    @Size(max = 500, message = "L'URL dell'immagine non puo superare 500 caratteri")
    String imgUrl,

    @NotNull(message = "L'id della categoria e obbligatorio")
    Long id_cat,

    String categoryName

) {}
