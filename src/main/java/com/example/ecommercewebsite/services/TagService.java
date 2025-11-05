package com.example.ecommercewebsite.services;

import com.example.ecommercewebsite.dtos.res.ResponseMessage;
import com.example.ecommercewebsite.models.Tag;
import com.example.ecommercewebsite.repositories.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepo tagRepo;

    @Transactional
    public ResponseMessage createTag(String tagName) {
        Optional<Tag> tag = tagRepo.findByName(tagName);
        if (tag.isPresent()) return new ResponseMessage("Tag already exists!");
        tagRepo.save(Tag.builder().name(tagName).build());
        return new ResponseMessage("Tag created successfully.");
    }

    @Transactional
    public ResponseMessage deleteTag(UUID id) {
        Optional<Tag> tag = tagRepo.findById(id);
        if (tag.isEmpty()) return new ResponseMessage("Tag not found!");
        tagRepo.delete(tag.get());
        return new ResponseMessage("Tag deleted successfully.");
    }

    @Transactional(readOnly = true)
    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }
}
