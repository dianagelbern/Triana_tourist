package com.salesianostriana.trianatourist.controller;

import com.salesianostriana.trianatourist.dto.route.CreateRouteDto;
import com.salesianostriana.trianatourist.dto.route.RouteDtoConverter;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;
    private final RouteDtoConverter converter;

    @GetMapping("/")
    private List<Route> findAll(){
        return service.findAll();
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
    public void delete(Route r){
        service.delete(r);
    }
}
