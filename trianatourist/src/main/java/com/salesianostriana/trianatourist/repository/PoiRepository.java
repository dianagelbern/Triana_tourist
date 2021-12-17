package com.salesianostriana.trianatourist.repository;

import com.salesianostriana.trianatourist.model.Poi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;

public interface PoiRepository extends JpaRepository<Poi, Long> {

    @EntityGraph("grafo-poi-category-route")
    List<Poi> findAll();
}
