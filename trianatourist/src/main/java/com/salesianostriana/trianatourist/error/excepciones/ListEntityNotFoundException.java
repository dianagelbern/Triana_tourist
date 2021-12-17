package com.salesianostriana.trianatourist.error.excepciones;

import com.salesianostriana.trianatourist.dto.GetCategoryDto;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class<GetCategoryDto> message) {
        super(message);
    }
}
