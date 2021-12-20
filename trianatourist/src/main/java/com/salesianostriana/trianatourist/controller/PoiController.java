package com.salesianostriana.trianatourist.controller;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.poi.CreatePoiDto;
import com.salesianostriana.trianatourist.dto.poi.GetPoiDto;
import com.salesianostriana.trianatourist.dto.poi.PoiDtoConverter;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.service.CategoryService;
import com.salesianostriana.trianatourist.service.PoiService;
import com.salesianostriana.trianatourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PoiController {

    private final PoiService service;
    private final RouteService routeService;
    private final PoiDtoConverter converter;
    private final CategoryService category;

    @GetMapping("/")
    private List<GetPoiDto> findAll(){
        List<GetPoiDto> res = service.findAll().stream().map( r -> converter.poiToGetPoiDtoConverter(r)).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/{id}")
    public Optional<Poi> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public GetPoiDto create(@Valid @RequestBody CreatePoiDto dto){
        Poi p = service.save(dto, converter, category);
        return  converter.poiToGetPoiDtoConverter(p);
    }

    @PutMapping("/{id}")
    public GetPoiDto edit(@Valid @RequestBody CreatePoiDto dto, @PathVariable Long id, PoiDtoConverter converter){
        Poi p = service.edit(dto, converter, id, category);
        GetPoiDto poiDto = converter.poiToGetPoiDtoConverter(p);
        return poiDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Poi> p = service.findById(id);

        service.delete(p.get(), routeService);
        return ResponseEntity.noContent().build();
    }
}
