package ru.job4j.food.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.food.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Disabled
class UserServiceTest {

    private UserService service;

    @BeforeEach
    public void init() {
        service = new UserService();
    }

   @Test
    public void whenBuyIsFalse() {
        User user = new User(1, "Danil", "Nikishin", "email", LocalDateTime.now());
        Role role = new Role(1, "user");
        user.setRole(role);
        Food milk = new Food(1, "milk", "food", 100);
        Order order = new Order(1, new ArrayList<>() {{
            add(milk);
        }}, LocalDateTime.now(), "mira 28", user, false);
        user.setOrders(new ArrayList<>() {{
            add(order);
        }});
        Courier courier = new Courier(1, "Petr", "kotova 12", user);
        service.doOrder(courier);
        assertThat(courier.getUser().getOrders().get(0).getOrderReport()).isFalse();
   }

}