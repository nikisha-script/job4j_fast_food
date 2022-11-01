package ru.job4j.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import ru.job4j.notification.dto.OrderDto;
import ru.job4j.notification.model.Message;
import ru.job4j.notification.service.MessageService;

@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerController {

    private final MessageService messageService;

    @KafkaListener(topics = {"messages"}, containerFactory = "singleFactory")
    public void msgListener(OrderDto record) {
        log.info("Поступил новый заказ: ");
        log.info(String.valueOf(record));
        Message message = new Message();
        message.setText("Заказ для: " + record.getFullName());
        Message rsl = messageService.save(message);
        log.info("Заказ сохранен в бд: " + rsl.getText());
    }

}
