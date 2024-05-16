package com.rossbach.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "MANGA")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nom;
    private String synopsis;
    private int tomes;
    private int chapitres;



    public Manga() {
    }

    public Manga(int id, String nom, String synopsis, int tomes, int chapitres) {
        this.id = id;
        this.nom = nom;
        this.synopsis = synopsis;
        this.tomes = tomes;
        this.chapitres = chapitres;

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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getTomes() {
        return tomes;
    }

    public void setTomes(int tomes) {
        this.tomes = tomes;
    }

    public int getChapitres() {
        return chapitres;
    }

    public void setChapitres(int chapitres) {
        this.chapitres = chapitres;
    }
}
