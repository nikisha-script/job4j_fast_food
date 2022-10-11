package ru.job4j.domains.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
public class Person {

    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Role role;

}
