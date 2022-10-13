package ru.job4j.dish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.store.CategoryRepository;
import ru.job4j.dish.store.DishRepository;
import ru.job4j.dish.entity.Category;
import ru.job4j.dish.entity.Dish;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;


    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish create(DishDto dishDto) {
        Dish dish = new Dish();
        Category category = categoryRepository.findByName(dishDto.getCategoryName()).get();
        dish.setName(dishDto.getName());
        dish.setCost(dishDto.getCost());
        dish.setCategory(category);
        return dishRepository.save(dish);
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

}
