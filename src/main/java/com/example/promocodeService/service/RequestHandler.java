package com.example.promocodeService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * This class uses non-blocking Spring WebFlux Mono publisher to obtain value of a promocode
 * without blocking the whole API.
 */
@Service
public class RequestHandler {

    private final WebClient.Builder builder;
    private static final String THIRD_PARTY_URI = "http://localhost:8080/generator/";

    public RequestHandler(WebClient.Builder builder) {
        this.builder = builder;
    }

    public Mono<String> requestPromocode(Long userId) {
        return builder.build()
                .get()
                .uri(THIRD_PARTY_URI + userId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
