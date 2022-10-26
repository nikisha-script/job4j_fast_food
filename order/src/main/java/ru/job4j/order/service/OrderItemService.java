package ru.job4j.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.dto.OrderItemDto;
import ru.job4j.order.mapper.ItemOrderMapper;
import ru.job4j.order.model.OrderItem;
import ru.job4j.order.store.OrderItemRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ItemOrderMapper itemOrderMapper;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem save(OrderItemDto orderItemDto) {
        return orderItemRepository.save(itemOrderMapper.mapperToOrderItem(orderItemDto));
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

}
