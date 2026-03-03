package com.scuola.apichallenge.graphql;

import com.scuola.apichallenge.model.Film;
import com.scuola.apichallenge.repository.FilmRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

// Intercetta le query GraphQL definite nello schema.
@Controller
public class FilmGraphqlController {

    private final FilmRepository repository;

    public FilmGraphqlController(FilmRepository repository) {
        this.repository = repository;
    }

    // Mappa la query 'getFilmsGraphql' al metodo corrispondente per il data fetching.
    @QueryMapping
    public List<Film> getFilmsGraphql() {
        return repository.findAll();
    }
}