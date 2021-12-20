package com.salesianostriana.trianatourist.dto.route;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.poi.PoiDtoConverter;
import com.salesianostriana.trianatourist.model.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RouteDtoConverter {
    public GetRouteDto routeToGetRouteDtoConverter(Route r, PoiDtoConverter converter){
        return GetRouteDto.builder()
                .name(r.getName())
                .steps(r.getSteps().stream().map(converter::poiToGetPoiDtoConverter).collect(Collectors.toList())).build();
    }

    public Route createRouteDtoToRoute(CreateRouteDto r){
        return Route.builder()
                .name(r.getName()).build();
    }
}
