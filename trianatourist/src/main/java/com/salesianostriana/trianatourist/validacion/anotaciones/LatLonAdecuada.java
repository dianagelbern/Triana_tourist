package com.salesianostriana.trianatourist.validacion.anotaciones;

import com.salesianostriana.trianatourist.validacion.validadores.LatLonAdecuadaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LatLonAdecuadaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LatLonAdecuada {

    String message() default "Debe tener un formato adecuado de cordenadas";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    String locationField();
}
