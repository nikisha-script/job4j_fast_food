package ru.job4j.dish.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.dish.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
