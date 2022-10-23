package ru.job4j.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ApiDtoOrders implements Serializable {

    private double price;
    private String fullName;
    private String address;
    private String phone;
    private String deliveryMethodPay;
    private List<ApiDtoItemOrder> items = new ArrayList<>();

    public ApiDtoOrders(double price,
                        String fullName,
                        String address,
                        String phone,
                        String deliveryMethodPay) {
        this.price = price;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.deliveryMethodPay = deliveryMethodPay;
    }
}
