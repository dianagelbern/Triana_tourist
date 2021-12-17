package com.salesianostriana.trianatourist.error.excepciones;

import com.salesianostriana.trianatourist.dto.GetCategoryDto;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName()));
    }
}
