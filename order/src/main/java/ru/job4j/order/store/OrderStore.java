package ru.job4j.order.store;

import ru.job4j.domains.entity.Dish;
import ru.job4j.domains.entity.Order;
import ru.job4j.domains.entity.Person;

import java.util.List;
import java.util.Optional;

public interface OrderStore {

    Optional<Order> doOrder(List<Dish> dishes, Person person);

    Double getTotalCostOfOrder();

    Integer getCountDish();

    Boolean verifyIsDone();

}
