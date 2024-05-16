package com.rossbach.controller;

import com.rossbach.entities.Anime;
import com.rossbach.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "anime")
public class AnimeController {

    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createAnime(@RequestBody Anime anime) {
        this.animeService.createAnime(anime);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Anime> showAnime(){
        return this.animeService.showAnime();
    }

    @GetMapping(path = "{id}")
    public Anime showAnimeById(@PathVariable int id) {
        return this.animeService.showAnimeById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAnime(@PathVariable int id) {
        Anime animeExist = this.animeService.showAnimeById(id);
        if (animeExist != null) {
            this.animeService.deleteAnime(id);
        }

        else {
            throw new RuntimeException("Cet utilisateur n'existe pas");
        }

    }
}
