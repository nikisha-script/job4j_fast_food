package ru.job4j.order.service;

import lombok.RequiredArgsConstructor;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final KafkaTemplate<Long, OrderDto> kafkaTemplate;

    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::convertToOrderDto)
                .collect(Collectors.toList());
    }

    public Order save(OrderDto orderDto) {
        ListenableFuture<SendResult<Long, OrderDto>> future = kafkaTemplate.send("msg", orderDto);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
        return orderRepository.save(mapper.convertToOrder(orderDto));
    }

    public OrderDto findById(Long id) {
        return mapper.convertToOrderDto(orderRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not found");
        }));
    }

}
