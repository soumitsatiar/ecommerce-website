package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.dtos.ProductDTO;
import com.example.ecommercewebsite.dtos.res.StringResponse;
import com.example.ecommercewebsite.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class SellerController {

    private final ProductService productService;

    @PostMapping("/create/product")
    public ResponseEntity<StringResponse> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        productService.createProduct(productDTO, email);
        return ResponseEntity.ok(new StringResponse("product successfully created"));
    }

}
