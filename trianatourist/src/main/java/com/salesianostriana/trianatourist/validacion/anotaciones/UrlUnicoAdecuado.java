package com.salesianostriana.trianatourist.validacion.anotaciones;

import com.salesianostriana.trianatourist.validacion.validadores.UrlUnicoAdecuadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UrlUnicoAdecuadoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlUnicoAdecuado {

    String message() default "El formato de la imagen debe de ser un url";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String photoField();
    String photoField2();
    String photoField3();
}
