package ru.job4j.food.store;

import ru.job4j.food.entity.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {

    List<Courier> findAll();

    Optional<Courier> findById(Long id);

    Optional<Courier> findByName(String name);

    void delete(Long id);

    void saveOrUpdate(Courier courier);

    void updateGeolocation();

}
