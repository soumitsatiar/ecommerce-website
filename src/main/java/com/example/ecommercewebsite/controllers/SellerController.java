package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.dtos.ProductDTO;
import com.example.ecommercewebsite.dtos.res.ResponseMessage;
import com.example.ecommercewebsite.dtos.res.StringResponse;
import com.example.ecommercewebsite.models.Product;
import com.example.ecommercewebsite.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class SellerController {

    private final ProductService productService;

    @PostMapping("/create/product")
    public ResponseEntity<StringResponse> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        System.out.println("hello world");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        productService.createProduct(productDTO, email);
        return ResponseEntity.ok(new StringResponse("product successfully created"));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<StringResponse> updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(new StringResponse(productService.updateProduct(productDTO, id)));
    }

    @GetMapping("/products")
    public List<Product>  getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") UUID id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<ResponseMessage> deleteProduct(@PathVariable("productId") UUID id) {
        return ResponseEntity.ok(new ResponseMessage(productService.deleteProduct(id)));
    }

}
