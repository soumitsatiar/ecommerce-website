package com.example.ecommercewebsite.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagDto {
    @Size(min = 1, message = "tag name should be between 3 and 15.")
    private String name;
}
