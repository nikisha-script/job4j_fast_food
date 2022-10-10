package ru.job4j.dish.store;

import ru.job4j.domains.entity.Dish;

import java.util.List;
import java.util.Optional;

public interface DishStore {

    Optional<Dish> addDish(Dish dish);

    Optional<Dish> findDishByName(Dish name);

    Optional<Dish> findDishById(Long id);

    List<Dish> findAllDish();

    boolean delete(Long id);

    boolean update(Long id);

}
