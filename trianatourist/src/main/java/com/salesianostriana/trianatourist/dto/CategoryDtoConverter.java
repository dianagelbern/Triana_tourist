package com.salesianostriana.trianatourist.dto;

import com.salesianostriana.trianatourist.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDtoConverter {

    public GetCategoryDto categoryToGetCategoryDtoConverter(Category c){
        return GetCategoryDto.builder().name(c.getName()).build();
    }

    public Category createCategoryDtoToCategory(CreateCategoryDto c){
        return Category.builder().name(c.getName()).build();
    }
}
