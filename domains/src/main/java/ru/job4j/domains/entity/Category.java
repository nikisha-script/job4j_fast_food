package ru.job4j.domains.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class Category {

    private Long id;
    private String name;

}
