package ru.job4j.dish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiDishesToOrder implements Serializable {

    private List<ApiDishToOrder> dishes;

}
