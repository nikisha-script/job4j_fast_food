package ru.job4j.dish.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class CategoryDto {
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }
}
