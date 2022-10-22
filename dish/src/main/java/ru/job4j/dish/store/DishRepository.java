package ru.job4j.dish.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.dish.model.Category;
import ru.job4j.dish.model.Dish;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {

    Optional<Dish> findByName(String name);

}
