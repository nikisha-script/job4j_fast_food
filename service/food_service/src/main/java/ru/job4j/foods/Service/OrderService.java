package ru.job4j.foods.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.foods.model.ApiProductView;
import ru.job4j.foods.model.ApiProductsToOrderView;
import ru.job4j.foods.model.product.ProductDto;

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

    public String sendProductsToOrders(List<ProductDto> products) {
        ApiProductsToOrderView view = new ApiProductsToOrderView();
        view.setProducts(products.stream()
                .map(e -> new ApiProductView(e.getTitle(), e.getPrice()))
                .collect(Collectors.toList())
        );

        /* where, what, type response */
        return restTemplate.postForEntity(url, view, String.class).getBody();
    }

}
