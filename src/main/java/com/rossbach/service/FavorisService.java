package com.rossbach.service;

import com.rossbach.entities.Favoris;
import com.rossbach.repositories.FavorisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavorisService {

    private FavorisRepository favorisRepository;

    public FavorisService(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    public void createFavoris(Favoris favoris){

        this.favorisRepository.save(favoris);
        System.out.println(favoris);
    }


    public List<Favoris> showFavoris(){
        return this.favorisRepository.findAll();
    }
}
