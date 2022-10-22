package ru.job4j.dish.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.dish.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
