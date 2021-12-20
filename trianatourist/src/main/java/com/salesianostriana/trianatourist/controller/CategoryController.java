package com.salesianostriana.trianatourist.controller;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.category.CreateCategoryDto;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;
    private final CategoryDtoConverter converter;

    @GetMapping("/")
    private List<Category> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public Category create(@Valid @RequestBody CreateCategoryDto dto){
        return service.save(dto, converter);
    }

    @PutMapping("/{id}")
    public Category edit(@Valid @RequestBody CreateCategoryDto dto, Category c){
        return service.edit(dto, c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Category c){
        service.delete(c);
        return ResponseEntity.noContent().build();
    }
}
