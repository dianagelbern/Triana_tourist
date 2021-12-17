package com.salesianostriana.trianatourist.repository;

import com.salesianostriana.trianatourist.model.Poi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiRepository extends JpaRepository<Poi, Long> {
}
