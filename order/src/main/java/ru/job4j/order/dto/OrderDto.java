package ru.job4j.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    private double price;
    private String fullName;
    private String address;
    private String phone;
    private String deliveryMethodPay;
    private List<OrderItemDto> items;
    private LocalDateTime created;
    private boolean isDone;

}
