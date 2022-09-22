package ru.job4j.food.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {

    @EqualsAndHashCode.Include
    @NonNull
    private Long id;
    @NonNull
    private List<Food> foods;


}
