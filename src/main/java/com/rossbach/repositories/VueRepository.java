package com.rossbach.repositories;

import com.rossbach.entities.Vue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VueRepository extends JpaRepository<Vue, Integer> {
    List<Vue> findByUserId(int userId);
    void deleteByUserId(int userId);
}
