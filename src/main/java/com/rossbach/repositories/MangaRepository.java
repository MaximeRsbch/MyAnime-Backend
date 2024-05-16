package com.rossbach.repositories;

import com.rossbach.entities.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
    Manga findByNom(String nom);
}
