package ru.job4j.order.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
