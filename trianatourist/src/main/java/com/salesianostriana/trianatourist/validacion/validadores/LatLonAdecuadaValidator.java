package com.salesianostriana.trianatourist.validacion.validadores;

import com.salesianostriana.trianatourist.validacion.anotaciones.LatLonAdecuada;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LatLonAdecuadaValidator implements ConstraintValidator<LatLonAdecuada, Object> {

    private String locationField;

    @Override
    public void initialize(LatLonAdecuada constraintAnnotation) {
        locationField = constraintAnnotation.locationField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String location = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(locationField);
        String verify =  "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
        return StringUtils.hasText(location) && location.matches(verify);
    }
}
