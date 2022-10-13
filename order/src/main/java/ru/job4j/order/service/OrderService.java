package ru.job4j.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.entity.Order;
import ru.job4j.order.entity.OrderItem;
import ru.job4j.order.store.OrderItemRepository;
import ru.job4j.order.store.OrderRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository itemRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public OrderItem createItem(OrderItem item) {
        return itemRepository.save(item);
    }

}
