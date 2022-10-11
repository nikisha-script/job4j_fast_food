package ru.job4j.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.service.DishService;
import ru.job4j.dish.entity.Dish;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @GetMapping
    public List<DishDto> getProducts() {
        return dishService.findAll()
                .stream()
                .map(e -> DishDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .categoryName(e.getCategory().getTitle())
                        .cost(e.getCost())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{dishId}")
    public DishDto getDish(@PathVariable(name = "dishId") Long dishId) {
        return dishService.findById(dishId)
                .map(e -> DishDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .categoryName(e.getCategory().getTitle())
                        .cost(e.getCost())
                        .build())
                .orElseThrow(() -> new EntityNotFoundException("Category " + dishId + " is not found"));
    }

    @PostMapping
    public Dish createNewProduct(@RequestBody DishDto dishDto) {
        return dishService.create(dishDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dishService.delete(id);
    }


}
