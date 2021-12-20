package com.salesianostriana.trianatourist.error.excepciones;

public class ElementosRepeditosException extends RuntimeException{

    public ElementosRepeditosException(Class clazz) {
        super(String.format("No se puede agregar el elemento %s ya que existe actualmente en la lista", clazz.getName()));
    }
}
