package ru.job4j.food.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Food {

    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String category;
    private int price;

    public Food(@NonNull int id,
                @NonNull String name,
                @NonNull String category,
                @NonNull int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
