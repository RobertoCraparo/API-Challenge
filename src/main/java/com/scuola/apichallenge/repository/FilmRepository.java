package com.scuola.apichallenge.repository;

import com.scuola.apichallenge.model.Film;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Gestisce la persistenza in memoria dei dati per i test delle API.
@Repository
public class FilmRepository {
    private final List<Film> films = new ArrayList<>();

    public FilmRepository() {
        films.add(new Film(UUID.randomUUID().toString(), "Matrix", "Wachowski", 1999));
        films.add(new Film(UUID.randomUUID().toString(), "Interstellar", "Nolan", 2014));
    }

    // Restituisce l'intera collezione.
    public List<Film> findAll() {
        return films;
    }

    // Genera un UUID se assente e salva la risorsa nella collezione.
    public Film save(Film film) {
        if (film.getId() == null || film.getId().isEmpty()) {
            film.setId(UUID.randomUUID().toString());
        }
        films.add(film);
        return film;
    }
}