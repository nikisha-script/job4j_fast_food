package ru.job4j.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.service.DishService;
import ru.job4j.dish.entity.Dish;
import ru.job4j.dish.service.OrderService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;
    private final OrderService orderService;

    @GetMapping
    public List<Dish> getAll() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish createNewProduct(@RequestBody DishDto dishDto) {
        return dishService.create(dishDto);
    }

    @PostMapping("/orders")
    public String sendToOrder(@RequestBody List<DishDto> dishDto) {
        return orderService.sendDishesToOrders(dishDto);
    }

}