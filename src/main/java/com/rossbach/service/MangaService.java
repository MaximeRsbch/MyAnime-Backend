package com.rossbach.service;

import com.rossbach.entities.Manga;
import com.rossbach.repositories.MangaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    private MangaRepository mangaRepository;

    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public void createManga(Manga manga) {
        Manga mangaDansLaBDD = this.mangaRepository.findByNom(manga.getNom());
        if(mangaDansLaBDD == null) {
            this.mangaRepository.save(manga);
        }
        else {
            throw new RuntimeException("Ce manga existe déjà dans la BDD");
        }

    }

    public List<Manga> showManga() {
        return this.mangaRepository.findAll();
    }

    public Manga showMangaById(int id){
        Optional<Manga> mangaById = this.mangaRepository.findById(id);
        return mangaById.orElse(null);
    }

    public void deleteManga(int id){
        this.mangaRepository.deleteById(id);
    }
}
