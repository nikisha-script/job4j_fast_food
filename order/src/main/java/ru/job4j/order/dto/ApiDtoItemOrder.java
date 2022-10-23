package ru.job4j.order.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class ApiDtoItemOrder implements Serializable {

    private String name;
    private Double price;

    public ApiDtoItemOrder(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
