package ru.job4j.dish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiDishToOrder {

    private String name;
    private String categoryName;
    private Double cost;

}
