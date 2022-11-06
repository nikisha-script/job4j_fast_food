package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.order.service.OrderService;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumerController {

    private final OrderService orderService;

    @KafkaListener(topics = {"cooked_order"})
    public void listenPreorderQueue(String record) {
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
