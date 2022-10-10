package ru.job4j.delivery.service;

import ru.job4j.delivery.store.DeliveryStore;
import ru.job4j.domains.entity.Person;

import java.util.Optional;

public class DeliveryService implements DeliveryStore {

    @Override
    public Optional<Person> addCourier(Person person) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> findCourierById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> findCourierByName(String name) {
        return Optional.empty();
    }

    @Override
    public void completeOrder() {

    }

    @Override
    public String geolocationUpdate() {
        return null;
    }
}
