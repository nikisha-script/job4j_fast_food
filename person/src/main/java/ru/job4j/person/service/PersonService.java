package ru.job4j.person.service;


import ru.job4j.domains.entity.Person;
import ru.job4j.person.store.PersonStore;

import java.util.List;
import java.util.Optional;

public class PersonService implements PersonStore {

    @Override
    public Optional<Person> addPerson(Person person) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> findPersonByName(Person name) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> findPersonById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAllPerson() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Long id) {
        return false;
    }
}
