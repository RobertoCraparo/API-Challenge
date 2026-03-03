package com.scuola.apichallenge.rest;

import com.scuola.apichallenge.model.Film;
import com.scuola.apichallenge.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Espone gli endpoint RESTful serializzando le risposte in formato JSON.
@RestController
@RequestMapping("/api/films")
public class FilmRestController {

    private final FilmRepository repository;

    public FilmRestController(FilmRepository repository) {
        this.repository = repository;
    }

    // Gestisce le richieste GET per il recupero delle risorse.
    @GetMapping
    public List<Film> getFilms() {
        return repository.findAll();
    }

    // Gestisce le richieste POST per la creazione di nuove risorse.
    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return repository.save(film);
    }
}