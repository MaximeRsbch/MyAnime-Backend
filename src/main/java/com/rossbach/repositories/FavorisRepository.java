package com.rossbach.repositories;

import com.rossbach.entities.Favoris;
import com.rossbach.entities.Vue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {

    List<Vue> findByUserId(int userId);
    void deleteByUserId(int userId);
}
