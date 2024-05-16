CREATE TABLE MyAnime;

CREATE TABLE USER (
    ID integer primary key not null AUTO_INCREMENT,
    EMAIL varchar(50),
    PASSWORD varchar(20)
);

CREATE TABLE ANIME (
    ID integer primary key not null AUTO_INCREMENT,
    TYPE varchar(10),
    SAISON integer,
    EPISODE integer,
    VUE bit,
    USER_ID integer,
    CONSTRAINT user_fk FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);

CREATE TABLE MANGA (
    ID integer primary key not null AUTO_INCREMENT,
    TYPE varchar(10),
    SYNOPSIS varchar(400),
    TOMES integer,
    CHAPITRE integer,
    VUE bit,
    USER_ID integer,
    CONSTRAINT user_fk FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);

CREATE TABLE FILM (
    ID integer primary key not null AUTO_INCREMENT,
    TYPE varchar(10),
    SYNOPSIS varchar(400),
    LONGUEUR integer,
    VUE bit,
    USER_ID integer,
    CONSTRAINT user_fk FOREIGN KEY (USER_ID) REFERENCES USER(ID)
)

CREATE TABLE SERIE (
    ID integer primary key not null AUTO_INCREMENT,
    TYPE varchar(10),
    SYNOPSIS varchar(400),
    SAISON integer,
    EPISODE integer,
    VUE bit,
    USER_ID integer,
    CONSTRAINT user_fk FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);