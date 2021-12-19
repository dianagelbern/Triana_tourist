package com.salesianostriana.trianatourist.validacion.validadores;

import com.salesianostriana.trianatourist.repository.CategoryRepository;
import com.salesianostriana.trianatourist.repository.RouteRepository;
import com.salesianostriana.trianatourist.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private RouteRepository routRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(o) && !routRepository.existsByName(o);
    }
}
