package ru.job4j.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.CategoryService;
import ru.job4j.dish.service.DishService;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
@CrossOrigin(origins = "http://localhost:3000")
public class DishController {

    private final DishService dishService;
    private final CategoryService categoryService;

    @GetMapping
    public List<Dish> findALl() {
        return dishService.findAll();
    }

    @GetMapping("/{dishId}")
    public Dish getDish(@PathVariable(name = "dishId") Long dishId) {
        return dishService.findById(dishId)
                .orElseThrow(() -> new EntityNotFoundException("Dish " + dishId + " is not found"));
    }

    @PostMapping
    public Dish create(@RequestBody DishDto dishDto) throws IOException {
        Dish dish = new Dish();
        byte[] images = Files.readAllBytes(Paths.get(String.valueOf(dishDto.getPath())).toAbsolutePath());
        dish.setName(dishDto.getName());
        dish.setDescription(dishDto.getDescription());
        dish.setRating(dishDto.getRating());
        dish.setCost(dishDto.getCost());
        dish.setWeight(dishDto.getWeight());
        dish.setCategory(categoryService.findByName(dishDto.getNameCategory()).get());
        dish.setImg(images);
        return dishService.create(dish);
    }




}
