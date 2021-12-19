package com.salesianostriana.trianatourist.dto.category;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GetCategoryDto {

    @NotEmpty(message = "{poi.name.empty}")
    @NotNull(message = "{poi.name.null}")
    private String name;
}
