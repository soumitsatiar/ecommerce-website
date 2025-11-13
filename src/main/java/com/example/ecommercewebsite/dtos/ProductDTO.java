package com.example.ecommercewebsite.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDTO(

        @Size(min = 1, max = 50)
        String productName,

        @NotNull(message = "Price cannot be null")
        Double price,

        @Min(0)
        Integer quantity,

        @Size(min = 1, max = 300)
        String body
) {
}
