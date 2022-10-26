package ru.job4j.dish.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final String url;

    public OrderService(RestTemplate restTemplate,
                        @Value("${market.order-service.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

}
