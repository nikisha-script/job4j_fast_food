package ru.job4j.dish.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DishDto {

    private Long id;
    private String name;
    private String categoryName;
    private Double cost;

}
