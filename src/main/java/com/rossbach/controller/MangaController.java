package com.rossbach.controller;

import com.rossbach.entities.Manga;
import com.rossbach.service.MangaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "manga")
public class MangaController {

    private MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createManga(@RequestBody Manga manga){
        this.mangaService.createManga(manga);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Manga> showManga() {
        return this.mangaService.showManga();
    }

    @GetMapping(path = "{id}")
    public Manga showMangaById(@PathVariable int id){
        return this.mangaService.showMangaById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteManga(@PathVariable int id){
        Manga mangaDelete = this.mangaService.showMangaById(id);
        if(mangaDelete != null) {
            this.mangaService.deleteManga(id);
        }
        else {
            throw new RuntimeException("Ce manga n'existe pas");
        }

    }
}
