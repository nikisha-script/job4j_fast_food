package ru.job4j.food.store;

import ru.job4j.food.entity.Courier;
import ru.job4j.food.entity.Order;
import ru.job4j.food.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> findAll();

    Optional<Order> findById(Long id);

    void delete(Long id);

    boolean doOrder(User user, Courier courier);


}
