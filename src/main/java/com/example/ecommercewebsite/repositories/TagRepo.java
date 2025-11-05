package com.example.ecommercewebsite.repositories;

import com.example.ecommercewebsite.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepo extends JpaRepository<Tag, UUID> {
    Optional<Tag> findByName(String name);
}
