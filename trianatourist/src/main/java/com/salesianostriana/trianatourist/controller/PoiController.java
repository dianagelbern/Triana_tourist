package com.salesianostriana.trianatourist.controller;

import com.salesianostriana.trianatourist.dto.poi.CreatePoiDto;
import com.salesianostriana.trianatourist.dto.poi.GetPoiDto;
import com.salesianostriana.trianatourist.dto.poi.PoiDtoConverter;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PoiController {

    private final PoiService service;
    private final PoiDtoConverter converter;

    @GetMapping("/")
    private List<Poi> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Poi> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public GetPoiDto create(@Valid @RequestBody CreatePoiDto dto){
        Poi p = service.save(dto, converter);

        return  converter.poiToGetPoiDtoConverter(p);
    }

    @PutMapping("/{id}")
    public Poi edit(@Valid @RequestBody CreatePoiDto dto, Poi e){
        return service.edit(dto, e);
    }

    @DeleteMapping("/{id}")
    public void delete(Poi e){
        service.delete(e);
    }
}
