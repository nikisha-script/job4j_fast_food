package ru.job4j.orders.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Role {

    @EqualsAndHashCode.Include
    private int id;
    private String name;

    public Role(@NonNull int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }
}
