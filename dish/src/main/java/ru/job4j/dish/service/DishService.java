package ru.job4j.dish.service;

import ru.job4j.dish.store.DishStore;
import ru.job4j.domains.entity.Dish;

import java.util.List;
import java.util.Optional;

public class DishService implements DishStore {

    @Override
    public Optional<Dish> addDish(Dish dish) {
        return Optional.empty();
    }

    @Override
    public Optional<Dish> findDishByName(Dish name) {
        return Optional.empty();
    }

    @Override
    public Optional<Dish> findDishById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dish> findAllDish() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Long id) {
        return false;
    }
}
