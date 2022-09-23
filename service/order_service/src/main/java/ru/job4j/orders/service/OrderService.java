package ru.job4j.orders.service;

import org.springframework.stereotype.Service;
import ru.job4j.orders.entity.Courier;
import ru.job4j.orders.entity.Order;
import ru.job4j.orders.entity.User;
import ru.job4j.orders.store.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderRepository {

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean doOrder(User user, Courier courier) {
        return false;
    }
}
