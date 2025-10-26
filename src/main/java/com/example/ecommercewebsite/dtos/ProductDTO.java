package com.example.ecommercewebsite.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDTO(

        @Size(min = 1, max = 50)
        String productName,

        @NotNull(message = "Price cannot be null")
        Double price,

        @Size(min = 1, max = 300)
        String body) {
}
