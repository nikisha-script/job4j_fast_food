package ru.job4j.kitchen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.kitchen.model.CategoryDto;
import ru.job4j.kitchen.model.DishDto;
import ru.job4j.kitchen.service.KitchenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {

    private final KitchenService kitchenService;

    @PostMapping("/create-categories")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return kitchenService.createCategory(categoryDto);
    }

    @PostMapping("/create-dish")
    public DishDto createDish(@RequestBody DishDto dishDto) {
        return kitchenService.createDish(dishDto);
    }

}
