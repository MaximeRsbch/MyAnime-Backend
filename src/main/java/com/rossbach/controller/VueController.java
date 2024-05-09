package com.rossbach.controller;

import com.rossbach.entities.*;
import com.rossbach.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "vue")
public class VueController {

    private VueService vueService;

    private UserService userService;
    private MangaService mangaService;
    private AnimeService animeService;
    private FilmService filmService;
    private SerieService serieService;

    public VueController(VueService vueService, UserService userService, MangaService mangaService, AnimeService animeService, FilmService filmService, SerieService serieService) {
        this.vueService = vueService;
        this.userService = userService;
        this.mangaService = mangaService;
        this.animeService = animeService;
        this.filmService = filmService;
        this.serieService = serieService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVue(@RequestBody Vue vue){
        User userExist = this.userService.showUserById(vue.getUser().getId());
        if (userExist == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("L'user avec l'id " + vue.getUser().getId() + " n'existe pas.");
        }
        this.vueService.createService(vue);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("La vue a bien été créer");
    }

    @DeleteMapping(path = "/user/{userId}")
    public void deleteVueByUserId(@PathVariable("userId") int userId) {
        this.vueService.deleteVueByUserId(userId);
    }
}
