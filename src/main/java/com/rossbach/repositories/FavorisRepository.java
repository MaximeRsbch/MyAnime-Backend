package com.rossbach.repositories;

import com.rossbach.entities.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {
}
