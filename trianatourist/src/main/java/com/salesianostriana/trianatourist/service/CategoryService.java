package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.category.CreateCategoryDto;
import com.salesianostriana.trianatourist.dto.category.GetCategoryDto;
import com.salesianostriana.trianatourist.dto.route.GetRouteDto;
import com.salesianostriana.trianatourist.error.excepciones.ListEntityNotFoundException;
import com.salesianostriana.trianatourist.error.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.repository.CategoryRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    @Autowired
    private CategoryRepository repository;
/*
    @Override
    public List<GetCategoryDto> findAll() {
        List<GetCategoryDto> res = super.findAll();
        if (res.isEmpty()){
            throw new ListEntityNotFoundException(GetCategoryDto.class);
        }else {
            return res;
        }
    }
*/
    @Override
    public Optional<Category> findById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);

        }else {
            return repository.findById(id);
        }
    }

    public Category save(CreateCategoryDto create, CategoryDtoConverter converter) {
        return repository.save(Category.builder().name(create.getName()).build());
    }

    public Category edit(CreateCategoryDto create, Category c) {
        c.setName(create.getName());
        return repository.save(c);
    }

    @Override
    public void delete(Category category) {
        super.delete(category);
    }

    @Override
    public List<Category> saveAll(List<Category> list) {
        return super.saveAll(list);
    }
}
