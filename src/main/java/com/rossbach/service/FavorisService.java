package com.rossbach.service;

import com.rossbach.entities.Favoris;
import com.rossbach.repositories.FavorisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
}
