package com.rossbach.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "FAVORIS")
public class Favoris {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "MANGA_ID")
    private Manga manga;

    @ManyToOne
    @JoinColumn(name = "ANIME_ID")
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "SERIE_ID")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    public Favoris() {
    }

    public Favoris(int id, User user, Manga manga, Anime anime, Serie serie, Film film) {
        this.id = id;
        this.user = user;
        this.manga = manga;
        this.anime = anime;
        this.serie = serie;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
