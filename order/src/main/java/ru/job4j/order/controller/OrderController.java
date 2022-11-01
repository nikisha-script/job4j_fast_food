package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.model.Order;
import ru.job4j.order.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderDto apiOrder) {
        return orderService.save(apiOrder);
    }

    @GetMapping("/id/{id}")
    public OrderDto findOrderById(@PathVariable(name = "id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/name/{name}")
    public OrderDto findOrderByName(@PathVariable(name = "name") String name) {
        return orderService.findByFullName(name);
    }

}
