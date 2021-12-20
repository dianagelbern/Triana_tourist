package com.salesianostriana.trianatourist.controller;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.poi.PoiDtoConverter;
import com.salesianostriana.trianatourist.dto.route.CreateRouteDto;
import com.salesianostriana.trianatourist.dto.route.GetRouteDto;
import com.salesianostriana.trianatourist.dto.route.RouteDtoConverter;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.service.PoiService;
import com.salesianostriana.trianatourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;
    private final RouteDtoConverter converter;
    private final PoiService poiService;
    private final PoiDtoConverter poiConverter;

    @GetMapping("/")
    private List<GetRouteDto> findAll(PoiDtoConverter p){
        List<GetRouteDto> res = service.findAll().stream().map(r -> converter.routeToGetRouteDtoConverter(r, p)).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/{id}")
    public Optional<Route> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public Route create(@Valid @RequestBody CreateRouteDto dto){
        return service.save(dto, converter);
    }

    @PutMapping("/{id}")
    public Route edit(@Valid @RequestBody CreateRouteDto dto, Route r){
        return service.edit(dto, r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Route r){
        service.delete(r);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/steps/{id2}")
    public ResponseEntity<GetRouteDto> addToRoutePois(@PathVariable Long id, @PathVariable Long id2){
        Optional<Poi> p = poiService.findById(id);
        Optional<Route> r = service.findById(id2);
        if(p.isPresent() && r.isPresent()){
            service.addToRoutePois(r.get(), p.get(), poiService);
            GetRouteDto dto = converter.routeToGetRouteDtoConverter(r.get(), poiConverter);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        }

        return ResponseEntity.notFound().build();
    }
}
