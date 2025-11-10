package com.example.ecommercewebsite.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer quantity;

    @ManyToOne
    private Product productId;

    @ManyToOne
    private User userId;
}
