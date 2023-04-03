package com.digitalhouse.catalogservice.api.controller;

import com.digitalhouse.catalogservice.api.client.MovieClient;
import com.digitalhouse.catalogservice.api.queue.MovieSender;
import com.digitalhouse.catalogservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final MovieClient client;

    private final MovieSender movieSender;

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
        return client.getMovieByGenre(genre);
    }

    @PostMapping("/salvar")
    public void saveMovie(@RequestBody Movie movie) {
        movieSender.send(movie);
    }
}
