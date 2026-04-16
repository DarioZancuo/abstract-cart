package com.ecommerce.cart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(

    Long id_cat,

    @NotBlank(message = "Il nome della categoria non puo essere vuoto")
    @Size(min = 2, max = 50, message = "Il nome deve contenere tra 2 e 50 caratteri")
    String name,

    @NotBlank(message = "La descrizione non puo essere vuota")
    @Size(min = 5, max = 255, message = "La descrizione deve contenere tra 5 e 255 caratteri")
    String description

) {}
