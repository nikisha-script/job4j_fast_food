package ru.job4j.order.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.order.model.Order;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order o where o.fullName like :fKey")
    Optional<Order> findByFullName(@Param("fKey") String fullName);

    @Modifying
    @Transactional
    @Query("UPDATE Order o set o.isDone = true where o.fullName like :fKey")
    void orderIsDone(@Param("fKey") String fullName);

}
