package ru.job4j.kitchen.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;
import ru.job4j.kitchen.dto.CategoryDto;
import ru.job4j.kitchen.dto.DishDto;
import ru.job4j.kitchen.dto.OrderDto;
import ru.job4j.kitchen.model.Message;
import ru.job4j.kitchen.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenService {

    @Value("${market.categories-service.url}")
    private String urlCategories;

    @Value("${market.dishes-service.url}")
    private String urlDishes;

    private final MessageRepository messageRepository;
    private final KafkaTemplate<Long, String> kafkaTemplate;
    private final RestTemplate restTemplate;

    public CategoryDto createCategory(CategoryDto categoryDto) {
        return restTemplate.postForObject(urlCategories, categoryDto, CategoryDto.class);
    }

    public DishDto createDish(DishDto dishDto) {
        return restTemplate.postForObject(urlDishes, dishDto, DishDto.class);
    }


    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public void sendMessage(OrderDto record) {
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
