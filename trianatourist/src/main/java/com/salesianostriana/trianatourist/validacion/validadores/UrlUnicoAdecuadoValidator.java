package com.salesianostriana.trianatourist.validacion.validadores;

import com.salesianostriana.trianatourist.validacion.anotaciones.UrlUnicoAdecuado;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Collator;

public class UrlUnicoAdecuadoValidator implements ConstraintValidator<UrlUnicoAdecuado, Object> {

    private String photoFiel;
    private String photoFiel2;
    private String photoFiel3;

    @Override
    public void initialize(UrlUnicoAdecuado constraintAnnotation) {
        photoFiel = constraintAnnotation.photoField();;
        photoFiel2 = constraintAnnotation.photoField2();
        photoFiel3 = constraintAnnotation.photoField3();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        String coverPhoto = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoFiel);
        String photo2 = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoFiel2);
        String photo3 = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photoFiel3);

        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);

        return coverPhoto.contentEquals(photo2);
    }
}
