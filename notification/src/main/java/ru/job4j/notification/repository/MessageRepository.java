package ru.job4j.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.notification.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
