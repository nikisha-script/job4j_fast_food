package ru.job4j.food.service;

import ru.job4j.food.entity.Courier;
import ru.job4j.food.entity.User;
import ru.job4j.food.store.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService implements UserRepository {

    public void doOrder(Courier courier) {
    }

    public String controlOfGeolocationCourier(Courier courier) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void saveOrUpdate(User user) {

    }
}
