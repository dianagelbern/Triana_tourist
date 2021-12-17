package com.salesianostriana.trianatourist.error.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message){
        super(message);
    }
}
