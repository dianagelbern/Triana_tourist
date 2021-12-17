package com.salesianostriana.trianatourist.dto;

import com.salesianostriana.trianatourist.model.Poi;
import lombok.*;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GetRouteDto {

    private String name;

    private List<Poi> steps;
}
