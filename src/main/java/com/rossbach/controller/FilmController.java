package com.rossbach.controller;

import com.rossbach.entities.Anime;
import com.rossbach.entities.Film;
import com.rossbach.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "film")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createFilm(@RequestBody Film film) {
        this.filmService.createFilm(film);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Film> showFilm(){
        return this.filmService.showFilm();
    }

    @GetMapping(path = "{id}")
    public Film showFilmById(@PathVariable int id) {
        return this.filmService.showFilmById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFilm(@PathVariable int id) {
        Film filmExist = this.filmService.showFilmById(id);
        if (filmExist != null) {
            this.filmService.deleteAnime(id);
        }

        else {
            throw new RuntimeException("Cet utilisateur n'existe pas");
        }

    }
}
