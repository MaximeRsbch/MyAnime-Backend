package com.rossbach.service;

import com.rossbach.entities.Serie;
import com.rossbach.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void createSerie(Serie serie){
        Serie serieDansLaBDD = this.serieRepository.findByNom(serie.getNom());
        if (serieDansLaBDD == null) {
            this.serieRepository.save(serie);
        }
        else {
            throw new RuntimeException("Cette serie existe déjà dans la BDD");
        }
    }

    public List<Serie> showSerie(){
        return this.serieRepository.findAll();
    }

    public Serie showSerieByID(int id){
        Optional<Serie> serieByID = this.serieRepository.findById(id);
        return serieByID.orElse(null);
    }

    public void deleteSerie(int id){
        this.serieRepository.deleteById(id);
    }
}
