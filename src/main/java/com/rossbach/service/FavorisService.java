package com.rossbach.service;

import com.rossbach.entities.Favoris;
import com.rossbach.entities.Vue;
import com.rossbach.repositories.FavorisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FavorisService {


    private FavorisRepository favorisRepository;

    public FavorisService(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    public void createFavoris(Favoris favoris){
        this.favorisRepository.save(favoris);
    }

    public List<Favoris> showFavoris(){
        return this.favorisRepository.findAll();
    }

    public Favoris showFavorisByID(int id){
        Optional<Favoris> favorisById = this.favorisRepository.findById(id);
        return favorisById.orElse(null);
    }

    public void deleteFavoris(int id){
        this.favorisRepository.deleteById(id);
    }

    public void deleteFavorisByUserId(int userId){
        this.favorisRepository.deleteByUserId(userId);
    }

    // Verif si l'userId existe bien dans la table Vue
    public boolean checkIfUserIdExistsInFavoris(int userId) {
        List<Favoris> favorises = favorisRepository.findByUserId(userId);
        return !favorises.isEmpty();
    }


    // Verif si une vue est bien associé à cet utilisateur
    public boolean checkIfFavorisBelongsToUser(int userId, int favorisId) {
        Optional<Favoris> favorisOptional = favorisRepository.findByIdAndUserId(favorisId, userId);
        return favorisOptional.isPresent();
    }

    // Supprimer une vue avec un userId
    public void deleteSingleFavorisByUserId(int userId, int favorisId) {
        Optional<Favoris> favorisOptional = favorisRepository.findByIdAndUserId(favorisId, userId);
        favorisOptional.ifPresent(vue -> favorisRepository.delete(vue));
    }
}
