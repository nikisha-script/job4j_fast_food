package ru.job4j.dish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {

    private String name;
    private String description;
    private int rating;
    private Double cost;
    private int weight;
    private Path path;
    private String nameCategory;

}
