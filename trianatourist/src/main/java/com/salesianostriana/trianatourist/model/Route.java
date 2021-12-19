package com.salesianostriana.trianatourist.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @ManyToMany
    @UniqueElements(message = "{route.steps.unico}") //Lo añado aquí ya que en el dto no tengo este atributo
    private List<Poi> steps = new ArrayList();

    public void addSteps(Poi p){
        this.getSteps().add(p);
        p.getRoutes().add(this);

    }

    public void removeSteps(Poi p){
        p.getRoutes().remove(this);
        this.getSteps().remove(p);
    }
}
