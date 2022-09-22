package ru.job4j.food.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Order {

    @EqualsAndHashCode.Include
    private int id;
    private List<Food> foods;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private String address;
    private User user;
    private Boolean orderReport;

    public Order(@NonNull int id,
                 @NonNull List<Food> foods,
                 LocalDateTime created,
                 @NonNull String address,
                 @NonNull User user,
                 @NonNull Boolean orderReport) {
        this.id = id;
        this.foods = foods;
        this.created = created;
        this.address = address;
        this.user = user;
        this.orderReport = orderReport;
    }

}
