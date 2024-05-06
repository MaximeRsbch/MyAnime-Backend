package com.rossbach.controller;

import com.rossbach.entities.Serie;
import com.rossbach.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "serie")
public class SerieController {

    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createSerie(@RequestBody Serie serie){
        this.serieService.createSerie(serie);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Serie> showSerie(){
        return this.serieService.showSerie();
    }

    @GetMapping(path = "{id}")
    public Serie showSerieByID(@PathVariable int id) {
        return this.serieService.showSerieByID(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSerie(@PathVariable int id){
        Serie serieDelete = this.serieService.showSerieByID(id);
        if(serieDelete != null){
            this.serieService.deleteSerie(id);
        }
        else{
            throw new RuntimeException("Cette série n'existe pas");
        }
    }
}
