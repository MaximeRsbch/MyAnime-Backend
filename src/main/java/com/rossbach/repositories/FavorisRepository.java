package com.rossbach.repositories;

import com.rossbach.entities.Favoris;
import com.rossbach.entities.Vue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {

    List<Favoris> findByUserId(int userId);
    void deleteByUserId(int userId);
    Optional<Favoris> findByIdAndUserId(int favorisId, int userId);
}
