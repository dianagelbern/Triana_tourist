package com.salesianostriana.trianatourist.dto.category;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateCategoryDto {
    @NotEmpty(message = "{category.name.empty}")
    private String name;
}
