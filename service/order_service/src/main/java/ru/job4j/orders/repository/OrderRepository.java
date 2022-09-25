package ru.job4j.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.orders.entity.MarketOrder;

@Repository
public interface OrderRepository extends JpaRepository<MarketOrder, Long> {
}
