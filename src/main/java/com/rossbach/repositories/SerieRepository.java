package com.rossbach.repositories;

import com.rossbach.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    Serie findByNom(String nom);
}
