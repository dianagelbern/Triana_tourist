package com.salesianostriana.trianatourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "grafo-route-poi",
                attributeNodes = {
                        @NamedAttributeNode("steps")
                }
        )
})
public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Builder.Default
    @ManyToMany
    private List<Poi> steps = new ArrayList();
}
