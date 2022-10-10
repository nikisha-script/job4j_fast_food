package ru.job4j.domains.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Order {

    private Long id;
    private List<Dish> dishes;
    private Boolean isDone;

}
