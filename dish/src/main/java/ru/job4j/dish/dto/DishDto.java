package ru.job4j.dish.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class DishDto {

    private String name;
    private String categoryName;
    private Double cost;

    public DishDto(String name, String categoryName, Double cost) {
        this.name = name;
        this.categoryName = categoryName;
        this.cost = cost;
    }
}
