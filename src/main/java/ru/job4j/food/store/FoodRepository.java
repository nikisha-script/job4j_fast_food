package ru.job4j.food.store;

import ru.job4j.food.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {

    List<Food> findAll();

    Optional<Food> findById(Long id);

    void delete(Long id);

    void saveOrUpdate(Food food);

}
