package com.salesianostriana.trianatourist.repository;

import com.salesianostriana.trianatourist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
