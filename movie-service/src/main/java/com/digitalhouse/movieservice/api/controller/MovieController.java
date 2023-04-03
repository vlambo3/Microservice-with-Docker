package com.digitalhouse.movieservice.api.controller;

import com.digitalhouse.movieservice.api.service.queue.MovieListener;
import com.digitalhouse.movieservice.api.service.MovieService;
import com.digitalhouse.movieservice.domain.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RefreshScope
@RestController
public class MovieController {

    private final MovieService service;

    private final MovieListener movieListener;

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.findByGenre(genre));
    }

    @PostMapping("/salvar")
    public void saveMovie(@RequestBody Movie movie) {
        movieListener.receive(movie);
    }
}
