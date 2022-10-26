package ru.job4j.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.notification.dto.OrderDto;
import ru.job4j.notification.model.Message;
import ru.job4j.notification.repository.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @KafkaListener(topics = {"msg"}, containerFactory = "singleFactory")
    public void msgListener(OrderDto record) {
        System.out.println("Поступил новый заказ: ");
        System.out.println(record);
        Message message = new Message();
        message.setText("Заказ для: " + record.getFullName());
        Message rsl = save(message);
    }

}
