package ru.job4j.delivery.store;

import ru.job4j.domains.entity.Person;

import java.util.Optional;

public interface DeliveryStore {

    Optional<Person> addCourier(Person person);

    Optional<Person> findCourierById(Long id);

    Optional<Person> findCourierByName(String name);

    void completeOrder();

    String geolocationUpdate();
}
