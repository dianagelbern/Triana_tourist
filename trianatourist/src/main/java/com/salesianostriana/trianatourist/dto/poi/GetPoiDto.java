package com.salesianostriana.trianatourist.dto.poi;

import com.salesianostriana.trianatourist.dto.category.GetCategoryDto;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Route;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GetPoiDto {
    private Long id;

    private String name, location, descripcion, coverPhoto, photo2, photo3;

    private String categoryName;

    private LocalDate date;
}
