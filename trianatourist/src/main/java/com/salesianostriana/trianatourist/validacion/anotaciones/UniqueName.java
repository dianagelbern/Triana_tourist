package com.salesianostriana.trianatourist.validacion.anotaciones;

import com.salesianostriana.trianatourist.validacion.validadores.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {

    String message() default "El valor del campo debe ser único";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};


}
