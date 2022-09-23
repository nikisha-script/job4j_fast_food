package ru.job4j.orders.store;

import org.springframework.stereotype.Repository;
import ru.job4j.orders.entity.Courier;
import ru.job4j.orders.entity.Order;
import ru.job4j.orders.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {

    List<Order> findAll();

    Optional<Order> findById(int id);

    void delete(int id);

    boolean doOrder(User user, Courier courier);


}
