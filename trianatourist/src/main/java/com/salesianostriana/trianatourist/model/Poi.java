package com.salesianostriana.trianatourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
                name = "grafo-poi-category-route",
                attributeNodes = {
                        @NamedAttributeNode("category"),
                        @NamedAttributeNode("routes")
                }
        ),
        @NamedEntityGraph(
                name = "grafo-poi-category",
                attributeNodes = {
                        @NamedAttributeNode("category")
                }
        ),
        @NamedEntityGraph(
                name = "grafo-poi-route",
                attributeNodes = {
                        @NamedAttributeNode("routes")
                }
        )
})
public class Poi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, location, coverPhoto, photo2, photo3;
    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"))
    private Category category;

    @Builder.Default
    @ManyToMany
    private List<Route> routes = new ArrayList<>();

    //Fecha de apertura - construcción
    private LocalDate date;

    public void addRoute(Route r){
        this.getRoutes().add(r);
        r.getSteps().add(this);

    }

    public void removeRoute(Route r){
        r.getSteps().remove(this);
        this.getRoutes().remove(r);
    }

}
