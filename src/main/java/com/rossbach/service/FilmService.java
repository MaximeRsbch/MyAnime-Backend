package com.rossbach.service;

import com.rossbach.entities.Anime;
import com.rossbach.entities.Film;
import com.rossbach.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void createFilm(Film film){
        Film filmDansLaBDD = this.filmRepository.findByNom(film.getNom());
        if(filmDansLaBDD == null){
            this.filmRepository.save(film);
        }
        else {
            throw new RuntimeException("Ce film existe déjà dans la BDD");
        }
    }

    public List<Film> showFilm(){
        return this.filmRepository.findAll();
    }

    public Film showFilmById(int id) {
        Optional<Film> filmById = this.filmRepository.findById(id);
        return filmById.orElse(null);
    }

    public void deleteAnime(int id) {
        this.filmRepository.deleteById(id);
    }
}
