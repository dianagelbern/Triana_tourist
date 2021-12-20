package com.salesianostriana.trianatourist.dto.route;

import com.salesianostriana.trianatourist.dto.poi.GetPoiDto;
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

    private Long id;

    private String name;

    private List<GetPoiDto> steps;
}
