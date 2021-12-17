package com.salesianostriana.trianatourist.dto.route;

import com.salesianostriana.trianatourist.model.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RouteDtoConverter {
    public GetRouteDto routeToGetRouteDtoConverter(Route r){
        return GetRouteDto.builder()
                .name(r.getName())
                .steps(r.getSteps()).build();
    }

    public Route createRouteDtoToRoute(CreateRouteDto r){
        return Route.builder()
                .name(r.getName())
                .steps(r.getSteps()).build();
    }
}
