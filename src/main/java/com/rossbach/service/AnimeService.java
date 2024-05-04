package com.rossbach.service;

import com.rossbach.entities.Anime;
import com.rossbach.repositories.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {

        this.animeRepository = animeRepository;
    }

    public void createAnime(Anime anime){
        Anime animeDansLaBDD = this.animeRepository.findByNom(anime.getNom());
        if(animeDansLaBDD == null){
            this.animeRepository.save(anime);
        }
        else {
            throw new RuntimeException("Cet anime existe déjà dans la BDD");
        }
    }

    public List<Anime> showAnime(){
        return this.animeRepository.findAll();
    }

    public Anime showAnimeById(int id) {
        Optional<Anime> animeById = this.animeRepository.findById(id);
        return animeById.orElse(null);
    }

    public void deleteAnime(int id) {
        this.animeRepository.deleteById(id);
    }
}
