package com.rossbach.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SERIE")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nom;
    private String type;
    private String synopsis;
    private int saison;
    private int episode;

    public Serie() {
    }

    public Serie(int id, String nom, String type, String synopsis, int saison, int episode) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.synopsis = synopsis;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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
