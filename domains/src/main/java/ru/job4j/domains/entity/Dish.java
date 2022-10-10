package ru.job4j.domains.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class Dish {

    private Long id;
    private String name;
    private Double cost;
    private List<Category> category;

}
