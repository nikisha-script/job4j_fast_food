package ru.job4j.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.notification.dto.OrderDto;
import ru.job4j.notification.model.Message;
import ru.job4j.notification.service.MessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getAll() {
        return new ResponseEntity<>(
                messageService.findAll(),
                HttpStatus.OK
        );
    }

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
