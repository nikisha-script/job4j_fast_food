package ru.job4j.orders.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class User {

    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String surname;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime birthDay;
    private Role role;
    private List<Order> orders;

    public User(@NonNull int id,
                @NonNull String name,
                @NonNull String surname,
                @NonNull String email,
                @NonNull LocalDateTime birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDay = birthDay;
    }


}
