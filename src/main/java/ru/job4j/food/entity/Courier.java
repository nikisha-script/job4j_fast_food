package ru.job4j.food.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Courier {

    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String geolocation;
    private User user;

    public Courier(@NonNull int id,
                   @NonNull String name,
                   @NonNull String geolocation,
                   @NonNull User user) {
        this.id = id;
        this.name = name;
        this.geolocation = geolocation;
        this.user = user;
    }
}
