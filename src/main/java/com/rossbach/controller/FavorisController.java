package com.rossbach.controller;

import com.rossbach.entities.Favoris;
import com.rossbach.service.FavorisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "favoris")
public class FavorisController {

    private FavorisService favorisService;

    public FavorisController(FavorisService favorisService) {
        this.favorisService = favorisService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createFavoris(@RequestBody Favoris favoris){
        this.favorisService.createFavoris(favoris);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Favoris> showFavoris(){
        return this.favorisService.showFavoris();
    }
}
