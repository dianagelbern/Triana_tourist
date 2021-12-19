package com.salesianostriana.trianatourist.repository;

import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.model.Route;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    boolean existsByName(String name);
    @EntityGraph("grafo-poi-category-route")
    List<Route> findAll();
}
