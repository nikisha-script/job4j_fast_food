package ru.job4j.food.service;

import ru.job4j.food.entity.Order;
import ru.job4j.food.store.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService implements OrderRepository {

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

}
