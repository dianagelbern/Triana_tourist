package com.salesianostriana.trianatourist.dto.category;

import com.salesianostriana.trianatourist.validacion.anotaciones.UniqueName;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class CreateCategoryDto {
    @NotEmpty(message = "{category.name.empty}")
    @UniqueName(message = "{nombre.unico}")
    private String name;
}
