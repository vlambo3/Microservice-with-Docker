package com.digitalhouse.movieservice.api.service;

import com.digitalhouse.movieservice.domain.models.Movie;
import com.digitalhouse.movieservice.domain.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

}
