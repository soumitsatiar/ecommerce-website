package com.example.ecommercewebsite.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ProductDTO(

        @Size(min = 1, max = 50)
        String productName,

        @NotNull(message = "Price cannot be null")
        Double price,

        @Min(0)
        Integer quantity,

        @NotNull
        UUID tagId,

        @Size(min = 1, max = 300)
        String body
) {
}
