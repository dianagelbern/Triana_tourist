package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.dto.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.GetCategoryDto;
import com.salesianostriana.trianatourist.error.excepciones.ListEntityNotFoundException;
import com.salesianostriana.trianatourist.error.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.repository.CategoryRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        List<Category> res = super.findAll();
        if (res.isEmpty()){
            throw new ListEntityNotFoundException(GetCategoryDto.class);
        }else {
            return res;
        }
    }

    @Override
    public Optional<Category> findById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);

        }else {
            return repository.findById(id);
        }
    }
/*
    @Override
    public Category save(Category category, CategoryDtoConverter dto) {
        return repository.save((Category) dto.)
    }
*/

    //Queda esta también
    @Override
    public Category edit(Category category) {
        return super.edit(category);
    }

    @Override
    public void delete(Category category) {
        super.delete(category);
    }

}
