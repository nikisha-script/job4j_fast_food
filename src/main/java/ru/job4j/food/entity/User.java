package ru.job4j.food.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @EqualsAndHashCode.Include
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private LocalDateTime birthDay;
    @NonNull
    private Role role;
    @NonNull
    private Order order;
    @NonNull
    private Courier courier;

}
