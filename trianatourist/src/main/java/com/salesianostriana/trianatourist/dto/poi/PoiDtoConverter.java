package com.salesianostriana.trianatourist.dto.poi;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Poi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PoiDtoConverter {


    public GetPoiDto poiToGetPoiDtoConverter(Poi p){
        return GetPoiDto.builder()
                .id(p.getId())
                .name(p.getName())
                .descripcion(p.getDescripcion())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .categoryName(p.getCategory().getName())
                .date(p.getDate()).build();
    }

    public Poi createPoiDtoToPoi(CreatePoiDto p) {
        return Poi.builder()
                .name(p.getName())
                .descripcion(p.getDescripcion())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .date(p.getDate()).build();
    }

    public Poi editPoiDto(CreatePoiDto p, Long id){

        Poi poiEdit = Poi.builder().id(id)
                .name(p.getName())
                .descripcion(p.getDescripcion())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .date(p.getDate()).build();
        return poiEdit;

    }
}
