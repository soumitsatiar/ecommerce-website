package com.example.ecommercewebsite.services;

import com.example.ecommercewebsite.dtos.ProductDTO;
import com.example.ecommercewebsite.models.Product;
import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.repositories.ProductRepo;
import com.example.ecommercewebsite.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    @Transactional
    public void createProduct(ProductDTO product, String email) {
        Optional<User> seller = userRepo.findByEmail(email);

        if (seller.isPresent()) {
            Product product1 = Product.builder()
                    .productName(product.productName())
                    .price(product.price())
                    .body(product.body())
                    .user(seller.get())
                    .build();

            productRepo.save(product1);
        }
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
