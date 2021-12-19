package com.salesianostriana.trianatourist.dto.route;

import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.validacion.anotaciones.UniqueName;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateRouteDto {

    @UniqueName(message = "{nombre.unico}")
    private String name;
}
