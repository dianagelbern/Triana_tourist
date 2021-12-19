package com.salesianostriana.trianatourist.validacion.validadores;

import com.salesianostriana.trianatourist.validacion.anotaciones.UniquePhoto;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhotoValidator implements ConstraintValidator<UniquePhoto, Object> {

    private String photo1Field;
    private String photo2Field;
    private String photo3Field;

    @Override
    public void initialize(UniquePhoto constraintAnnotation) {
        photo1Field = constraintAnnotation.photo1Field();
        photo2Field = constraintAnnotation.photo2Field();
        photo3Field = constraintAnnotation.photo3Field();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        String coverPhoto = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo1Field);
        String photo2 = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo2Field);
        String photo3 = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo3Field);
        boolean sonIguales = false;
        if(photo2.contentEquals(photo3) || photo3.contentEquals(coverPhoto) || coverPhoto.contentEquals(photo2))
            sonIguales = true;
        return !sonIguales;
    }
}
