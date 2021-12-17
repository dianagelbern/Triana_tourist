package com.salesianostriana.trianatourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Poi {

    @Id
    @GeneratedValue
    private Long id;

    private String name, ubicacion, descripcion, coverPhoto, photo2, photo3;

    //Fecha de apertura - construcción
    private LocalDate date;
}
