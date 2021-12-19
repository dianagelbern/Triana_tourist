package com.salesianostriana.trianatourist.validacion.anotaciones;

import com.salesianostriana.trianatourist.validacion.validadores.UniquePhotoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniquePhotoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePhoto {

    String message() default "Las imágenes no pueden repetirse";
    Class <?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

    String photo1Field();
    String photo2Field();
    String photo3Field();
}
