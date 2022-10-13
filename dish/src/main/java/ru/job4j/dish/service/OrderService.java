package ru.job4j.dish.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.dish.dto.ApiDishToOrder;
import ru.job4j.dish.dto.ApiDishesToOrder;
import ru.job4j.dish.dto.DishDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final String url;

    public OrderService(RestTemplate restTemplate,
                        @Value("${market.order-service.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String sendDishesToOrders(List<DishDto> dishes) {
        ApiDishesToOrder view = new ApiDishesToOrder();
        view.setDishes(dishes.stream()
                .map(e -> new ApiDishToOrder(e.getName(), e.getCategoryName(), e.getCost()))
                .collect(Collectors.toList())
        );
        /* where, what, type response */
        return restTemplate.postForEntity(url, view, String.class).getBody();
    }

}
