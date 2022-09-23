package ru.job4j.orders.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.orders.entity.Order;
import ru.job4j.orders.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class MainController {

    private final OrderService service;

    public MainController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Order> findById(@PathVariable("id") int id) {
        return Optional.ofNullable(service.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found"
        )));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Optional<Order> order = service.findById(id);
        service.delete(order.get().getId());
        return ResponseEntity.ok().build();
    }
}
