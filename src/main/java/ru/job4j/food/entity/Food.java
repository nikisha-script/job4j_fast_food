package ru.job4j.food.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Food {

    @EqualsAndHashCode.Include
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String category;

}
