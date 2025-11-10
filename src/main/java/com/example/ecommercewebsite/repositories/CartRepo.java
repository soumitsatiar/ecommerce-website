package com.example.ecommercewebsite.repositories;

import com.example.ecommercewebsite.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepo extends JpaRepository<Cart, UUID> {
}
