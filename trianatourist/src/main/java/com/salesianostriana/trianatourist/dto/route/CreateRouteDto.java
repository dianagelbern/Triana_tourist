package com.salesianostriana.trianatourist.dto.route;

import com.salesianostriana.trianatourist.model.Poi;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateRouteDto {

    private String name;

    private List<Poi> steps;
}
