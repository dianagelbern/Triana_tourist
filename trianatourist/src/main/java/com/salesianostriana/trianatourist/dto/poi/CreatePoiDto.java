package com.salesianostriana.trianatourist.dto.poi;

import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.validacion.anotaciones.LatLonAdecuada;
import com.salesianostriana.trianatourist.validacion.anotaciones.UniquePhoto;
import lombok.*;
import org.hibernate.validator.constraints.URL;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@LatLonAdecuada(locationField = "location", message = "{poi.location.formato}")
@UniquePhoto(photo1Field = "coverPhoto", photo2Field = "photo2", photo3Field = "photo3", message = "{poi.photo.diferente}")
public class CreatePoiDto {

    @NotEmpty(message = "{poi.name.empty}")
    private String name;
    private String location;
    private String descripcion;
    @URL(message = "{poi.photo.url}")
    @NotNull(message = "{poi.photo.obligatoria}")
    private String coverPhoto;
    @URL(message = "{poi.photo.url}")
    private String photo2;
    @URL(message = "{poi.photo.url}")
    private String photo3;


    private Long category;

    private List<Route> routes;

    private LocalDate date;
}
