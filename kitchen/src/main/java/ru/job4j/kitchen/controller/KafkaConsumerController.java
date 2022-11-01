package ru.job4j.kitchen.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import ru.job4j.kitchen.dto.OrderDto;
import ru.job4j.kitchen.model.Message;
import ru.job4j.kitchen.service.KitchenService;

@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerController {

    private final KafkaTemplate<Long, String> kafkaTemplate;
    private final KitchenService kitchenService;


    @KafkaListener(topics = {"preorder"}, containerFactory = "singleFactory")
    public void msgListener(OrderDto record) {
        log.info("Поступил новый заказ: ");
        log.info(String.valueOf(record));
        Message message = new Message();
        message.setText("Заказ для: " + record.getFullName());
        Message rsl = kitchenService.save(message);
        log.info("Заказ сохранен в бд: " + rsl.getText());

        new Thread(() -> {
            ListenableFuture<SendResult<Long, String>> answer;
            try {
                Thread.sleep(5000);
                answer = kafkaTemplate.send("cooked_order", "Заказ для: [*" + record.getFullName() + "*] готов к выдаче");
            } catch (InterruptedException e) {
                log.error("InterruptedException ", e);
                answer = kafkaTemplate.send("cooked_order", "false");
            }
            answer.addCallback(success -> log.info(String.valueOf(success)),
                    error -> log.error(String.valueOf(error)));
            kafkaTemplate.flush();
        }).start();
    }

}
