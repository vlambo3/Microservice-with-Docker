package com.digitalhouse.movieservice.domain.data;

import com.digitalhouse.movieservice.domain.models.Movie;
import com.digitalhouse.movieservice.domain.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Movie(1L, "filme", "terror", "what"));
        repository.save(new Movie(2L, "borboleta", "terror", "what"));
        repository.save(new Movie(3L, "adedonha", "terror", "what"));
        repository.save(new Movie(4L, "pajero", "terror", "what"));
        repository.save(new Movie(5L, "dakar", "acción", "what"));
        repository.save(new Movie(6L, "shadow", "acción", "what"));
        repository.save(new Movie(7L, "boné", "romance", "what"));
        repository.save(new Movie(8L, "xícara", "romance", "what"));
    }
}
