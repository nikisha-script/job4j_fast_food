package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.entity.Order;
import ru.job4j.order.entity.OrderItem;
import ru.job4j.order.model.ApiDishToOrder;
import ru.job4j.order.model.DishesFromService;
import ru.job4j.order.service.OrderService;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody DishesFromService dishes) {
        Order order = new Order();
        order.setItems(dishes.getDishes()
                .stream()
                .map(e -> OrderItem.builder()
                        .name(e.getName())
                        .itemPrice(e.getCost())
                        .category(e.getCategoryName())
                        .marketOrder(order)
                        .build()).collect(Collectors.toList()));
        Double price = dishes.getDishes().stream()
                .map(ApiDishToOrder::getCost)
                .reduce(0., Double::sum);

        order.setPrice(price);
        order.setCreated(LocalDateTime.now());
        order.setIsDone(false);
        return orderService.save(order);
    }

    @GetMapping("{id}")
    public Order findOrderById(@PathVariable(name = "id") Long id) {
        return orderService.findById(id)
                .orElseThrow(EntityExistsException::new);
    }
}
