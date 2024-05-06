package com.rossbach.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ANIME")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nom;

    private String type;

    private int saison;

    private int episode;

    public Anime() {
    }

    public Anime(int id, String nom, String type, int saison, int episode) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.saison = saison;
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSaison() {
        return saison;
    }

    public void setSaison(int saison) {
        this.saison = saison;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }
}
