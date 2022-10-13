package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesFromService implements Serializable {

    private List<ApiDishToOrder> dishes;

}
