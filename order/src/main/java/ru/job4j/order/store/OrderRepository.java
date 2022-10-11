package ru.job4j.order.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
