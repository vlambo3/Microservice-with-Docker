package com.digitalhouse.movieservice.api.service.queue;

import com.digitalhouse.movieservice.api.service.MovieService;
import com.digitalhouse.movieservice.domain.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final MovieService service;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload Movie movie) {
        service.save(movie);
    }
}
