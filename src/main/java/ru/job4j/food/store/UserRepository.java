package ru.job4j.food.store;

import ru.job4j.food.entity.Courier;
import ru.job4j.food.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void delete(Long id);

    void saveOrUpdate(User user);

    String controlOfGeolocationCourier(Courier courier);


}
