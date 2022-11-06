package ru.job4j.kitchen.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.kitchen.dto.OrderDto;
import ru.job4j.kitchen.model.Message;
import ru.job4j.kitchen.service.KitchenService;


@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumerController {

    private final KitchenService kitchenService;

    @KafkaListener(topics = {"preorder"}, containerFactory = "singleFactory")
    public void listenPreorderQueue(OrderDto record) {
        log.info("Поступил новый заказ: ");
        log.info(String.valueOf(record));
        Message message = new Message();
        message.setText("Заказ для: " + record.getFullName());
        Message rsl = kitchenService.save(message);
        log.info("Заказ сохранен в бд: " + rsl.getText());

        kitchenService.sendMessage(record);
    }
}
