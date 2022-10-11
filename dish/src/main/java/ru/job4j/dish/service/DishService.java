package ru.job4j.dish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.mapper.DishMapper;
import ru.job4j.dish.store.DishRepository;
import ru.job4j.dish.entity.Dish;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish create(DishDto dish) {
        return dishRepository.save(dishMapper.mapToEntity(dish));
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

}
