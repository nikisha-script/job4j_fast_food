package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.model.Order;
import ru.job4j.order.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final KafkaTemplate<Long, OrderDto> kafkaTemplate;

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderDto apiOrder) {
        apiOrder.setCreated(LocalDateTime.now());
        ListenableFuture<SendResult<Long, OrderDto>> future = kafkaTemplate.send("messages", apiOrder);
        ListenableFuture<SendResult<Long, OrderDto>> preorder = kafkaTemplate.send("preorder", apiOrder);
        future.addCallback(success -> log.info(String.valueOf(success)),
                error -> log.error(String.valueOf(error)));
        preorder.addCallback(success -> log.info(String.valueOf(success)),
                error -> log.error(String.valueOf(error)));
        kafkaTemplate.flush();
        return orderService.save(apiOrder);
    }

    @GetMapping("/id/{id}")
    public OrderDto findOrderById(@PathVariable(name = "id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/name/{name}")
    public OrderDto findOrderByName(@PathVariable(name = "name") String name) {
        return orderService.findByFullName(name);
    }

    @KafkaListener(topics = {"cooked_order"})
    public void msgListener(String record) {
        log.info("Поступил ответ: " + record);
        if ("false".equals(record)) {
            /* TODO update later */
            log.info("Блюдо не может быть приготовлено");
        } else {
            String[] rsl = record.split("\\*");
            String name = rsl[1];
            orderService.orderIsDone(name);
            log.info("Заказ выдан");
        }
    }


}
