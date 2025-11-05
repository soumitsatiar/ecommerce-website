package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.dtos.TagDto;
import com.example.ecommercewebsite.dtos.res.ResponseMessage;
import com.example.ecommercewebsite.models.Tag;
import com.example.ecommercewebsite.services.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final TagService tagService;

    @PostMapping("/tag")
    public ResponseEntity<ResponseMessage> createTag(@RequestBody @Valid TagDto tagDto) {
        return ResponseEntity.ok(tagService.createTag(tagDto.getName()));
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<ResponseMessage> deleteTag(@PathVariable UUID id) {
        return ResponseEntity.ok(tagService.deleteTag(id));
    }

    @GetMapping("/tag/all")
    public ResponseEntity<List<Tag>> getTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }
}
