package com.salesianostriana.trianatourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
