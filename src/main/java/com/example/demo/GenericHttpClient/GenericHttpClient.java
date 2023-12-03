package com.example.demo.GenericHttpClient;

import reactor.core.publisher.Mono;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GenericHttpClient {
    public <T> Mono<T> sendRequest(
            String baseUrl,
            HttpMethod method,
            String endpoint,
            Object requestBody,
            HttpHeaders customHeaders,
            Class<T> responseType) {

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();

        return webClient.method(method)
                .uri(endpoint)
                .headers(httpHeaders -> httpHeaders.addAll(customHeaders))
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(responseType);
    }
}
