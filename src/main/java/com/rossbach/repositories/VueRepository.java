package com.rossbach.repositories;

import com.rossbach.entities.User;
import com.rossbach.entities.Vue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VueRepository extends JpaRepository<Vue, Integer> {
    List<Vue> findByUserId(int userId);
    void deleteByUserId(int userId);
    Optional<Vue> findByIdAndUserId(int vueId, int userId);
}
