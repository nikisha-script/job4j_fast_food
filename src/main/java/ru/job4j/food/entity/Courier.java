package ru.job4j.food.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Courier {

    @EqualsAndHashCode.Include
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Order order;
    @NonNull
    private String geolocation;
    @NonNull
    private String address;
    @NonNull
    private boolean orderReport;

}
