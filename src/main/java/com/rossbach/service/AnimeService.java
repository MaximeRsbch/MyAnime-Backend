package com.rossbach.service;

import com.rossbach.entities.Anime;
import com.rossbach.repositories.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    private AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void createAnime(Anime anime){
        this.animeRepository.save(anime);
    }
}
