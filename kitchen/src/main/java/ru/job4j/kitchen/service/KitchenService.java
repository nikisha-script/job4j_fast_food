package ru.job4j.kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.kitchen.dto.CategoryDto;
import ru.job4j.kitchen.dto.DishDto;
import ru.job4j.kitchen.model.Message;
import ru.job4j.kitchen.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenService {

    @Value("${market.categories-service.url}")
    private String urlCategories;

    @Value("${market.dishes-service.url}")
    private String urlDishes;

    private final MessageRepository messageRepository;

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


}
