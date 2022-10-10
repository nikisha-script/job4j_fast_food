package ru.job4j.person.store;

import ru.job4j.domains.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonStore {

    Optional<Person> addPerson(Person person);

    Optional<Person> findPersonByName(Person name);

    Optional<Person> findPersonById(Long id);

    List<Person> findAllPerson();

    boolean delete(Long id);

    boolean update(Long id);

}
