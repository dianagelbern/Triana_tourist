package com.salesianostriana.trianatourist.dto;

import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Route;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GetPoiDto {

    private String name, location, descripcion, coverPhoto, photo2, photo3;

    private Category category;

    private List<Route> routes;

    private LocalDate date;
}
