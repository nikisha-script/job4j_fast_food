package ru.job4j.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.orders.entity.MarketOrder;
import ru.job4j.orders.entity.OrderItem;
import ru.job4j.orders.repository.OrderRepository;
import ru.job4j.orders.view.ApiOrderView;
import ru.job4j.orders.view.ApiOrdersDetailsView;
import ru.job4j.orders.view.ApiProductView;
import ru.job4j.orders.view.ApiProductsToOrderView;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping
    public String createOrder(@RequestBody ApiProductsToOrderView body) {
        MarketOrder order = new MarketOrder();
        order.setItems(body.getProducts()
                .stream()
                .map(e -> OrderItem.builder()
                        .name(e.getTitle())
                        .itemPrice(e.getPrice())
                        .count(1)
                        .marketOrder(order)
                        .build())
                .collect(Collectors.toList()));
        Double price = body.getProducts().stream()
                .map(ApiProductView::getPrice)
                .reduce(0., Double::sum);
        order.setPrice(price);
        MarketOrder saveOrder = orderRepository.save(order);

        return "http://localhost:8189/api/v1/orders/" + saveOrder.getId();
    }

    @GetMapping("/{orderId}")
    public ApiOrderView getOrder(@PathVariable(name = "orderId") Long orderId,
                                 @RequestParam(defaultValue = "false") Boolean showDetails) {
        MarketOrder order = orderRepository.findById(orderId)
                .orElseThrow(EntityExistsException::new);
        List<ApiOrdersDetailsView> apiOrdersDetailsViews = null;
        if (showDetails) {
            apiOrdersDetailsViews = order.getItems().stream()
                    .map(i -> ApiOrdersDetailsView.builder()
                            .productName(i.getName())
                            .count(i.getCount())
                            .price(i.getItemPrice())
                            .build()).toList();
        }
        return ApiOrderView.builder()
                .orderId(order.getId())
                .summaryPrice(order.getPrice())
                .details(apiOrdersDetailsViews)
                .build();
    }

}
