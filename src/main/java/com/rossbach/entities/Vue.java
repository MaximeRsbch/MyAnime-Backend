package com.rossbach.entities;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "VUE")
public class Vue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "ANIME_ID")
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "MANGA_ID")
    private Manga manga;

    @ManyToOne
    @JoinColumn(name = "SERIE_ID")
    private Serie serie;

    public Vue() {
    }

    public Vue(int id, User user, Film film, Anime anime, Manga manga, Serie serie) {
        this.id = id;
        this.user = user;
        this.film = film;
        this.anime = anime;
        this.manga = manga;
        this.serie = serie;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }


}
