package ru.job4j.food.store;

import ru.job4j.food.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> findAll();

    Optional<Order> findById(Long id);

    void delete(Long id);

    void saveOrUpdate(Order order);

}
