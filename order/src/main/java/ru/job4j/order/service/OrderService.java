package ru.job4j.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.mapper.OrderMapper;
import ru.job4j.order.model.Order;
import ru.job4j.order.store.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<Long, OrderDto> kafkaTemplate;
    private final OrderMapper mapper;

    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::convertToOrderDto)
                .collect(Collectors.toList());
    }

    public Order save(OrderDto orderDto) {
        orderDto.setCreated(LocalDateTime.now());
        ListenableFuture<SendResult<Long, OrderDto>> future = kafkaTemplate.send("messages", orderDto);
        ListenableFuture<SendResult<Long, OrderDto>> preorder = kafkaTemplate.send("preorder", orderDto);
        future.addCallback(success -> log.info(String.valueOf(success)),
                error -> log.error(String.valueOf(error)));
        preorder.addCallback(success -> log.info(String.valueOf(success)),
                error -> log.error(String.valueOf(error)));
        kafkaTemplate.flush();
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
