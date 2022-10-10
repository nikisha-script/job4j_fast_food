package ru.job4j.order.service;

import ru.job4j.domains.entity.Dish;
import ru.job4j.domains.entity.Order;
import ru.job4j.domains.entity.Person;
import ru.job4j.order.store.OrderStore;

import java.util.List;
import java.util.Optional;

public class OrderService implements OrderStore {

    @Override
    public Optional<Order> doOrder(List<Dish> dishes, Person person) {
        return Optional.empty();
    }

    @Override
    public Double getTotalCostOfOrder() {
        return null;
    }

    @Override
    public Integer getCountDish() {
        return null;
    }

    @Override
    public Boolean verifyIsDone() {
        return null;
    }
}
