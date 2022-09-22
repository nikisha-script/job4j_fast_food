package ru.job4j.food.service;

import ru.job4j.food.entity.Courier;
import ru.job4j.food.store.CourierRepository;

import java.util.List;
import java.util.Optional;

public class CourierService implements CourierRepository {

    public void orderReport() {

    }

    public void updateGeolocation() {

    }

    @Override
    public List<Courier> findAll() {
        return null;
    }

    @Override
    public Optional<Courier> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Courier> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void saveOrUpdate(Courier courier) {

    }
}
