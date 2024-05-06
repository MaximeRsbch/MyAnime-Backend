package com.rossbach.repositories;

import com.rossbach.entities.Film;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film findByNom(String nom);
}
