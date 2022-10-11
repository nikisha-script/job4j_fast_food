package ru.job4j.dish.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.dish.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
