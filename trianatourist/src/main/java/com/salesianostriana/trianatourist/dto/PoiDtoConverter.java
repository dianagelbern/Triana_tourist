package com.salesianostriana.trianatourist.dto;

import com.salesianostriana.trianatourist.model.Poi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PoiDtoConverter {

    public GetPoiDto poiToGetPoiDtoConverter(Poi p){
        return GetPoiDto.builder()
                .name(p.getName())
                .descripcion(p.getDescripcion())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .category(p.getCategory())
                .routes(p.getRoutes())
                .date(p.getDate()).build();
    }

    public Poi createPoiDtoToPoi(CreatePoiDto p){
        return Poi.builder()
                .name(p.getName())
                .descripcion(p.getDescripcion())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .category(p.getCategory())
                .routes(p.getRoutes())
                .date(p.getDate()).build();
    }
}
