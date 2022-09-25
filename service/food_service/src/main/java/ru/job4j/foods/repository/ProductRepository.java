package ru.job4j.foods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.foods.entity.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
