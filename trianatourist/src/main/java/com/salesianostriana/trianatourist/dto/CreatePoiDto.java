package com.salesianostriana.trianatourist.dto;

import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Route;
import lombok.*;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreatePoiDto {

    private String name, location, descripcion, coverPhoto, photo2, photo3;

    private Category category;

    private List<Route> routes;

    private LocalDate date;
}
