package ru.job4j.foods.model.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private String categoryTitle;
    private Double price;

}

