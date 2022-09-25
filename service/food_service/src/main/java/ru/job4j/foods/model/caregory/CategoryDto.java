package ru.job4j.foods.model.caregory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    private Long id;
    private String title;
}
