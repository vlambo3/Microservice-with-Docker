package com.digitalhouse.catalogservice.api.queue;

import com.digitalhouse.catalogservice.api.client.MovieClient;
import com.digitalhouse.catalogservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final MovieClient client;

    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movie);
    }

}
