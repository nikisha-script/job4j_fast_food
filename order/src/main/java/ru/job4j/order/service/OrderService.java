package ru.job4j.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.mapper.OrderMapper;
import ru.job4j.order.model.Order;
import ru.job4j.order.store.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::convertToOrderDto)
                .collect(Collectors.toList());
    }

    public Order save(OrderDto orderDto) {
        return orderRepository.save(mapper.convertToOrder(orderDto));
    }

    public OrderDto findById(Long id) {
        return mapper.convertToOrderDto(orderRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not found");
        }));
    }

    public OrderDto findByFullName(String fullName) {
        return mapper.convertToOrderDto(orderRepository.findByFullName(fullName).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not found");
        }));
    }

    public void orderIsDone(String fullName) {
        orderRepository.orderIsDone(fullName);
    }

}
