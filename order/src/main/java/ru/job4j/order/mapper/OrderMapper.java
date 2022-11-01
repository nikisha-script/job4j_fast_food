package ru.job4j.order.mapper;

import org.springframework.stereotype.Component;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.dto.OrderItemDto;
import ru.job4j.order.model.Order;
import ru.job4j.order.model.OrderItem;

import java.util.ArrayList;

@Component
public class OrderMapper {

    public Order convertToOrder(OrderDto orderDto) {
        Order rsl = new Order();
        rsl.setPrice(orderDto.getPrice());
        rsl.setFullName(orderDto.getFullName());
        rsl.setAddress(orderDto.getAddress());
        rsl.setPhone(orderDto.getPhone());
        rsl.setDeliveryMethodPay(orderDto.getDeliveryMethodPay());
        rsl.setItems(new ArrayList<>() {{
            orderDto.getItems().forEach(e -> {
                OrderItem item = new OrderItem();
                item.setName(e.getName());
                item.setItemPrice(e.getPrice());
                item.setMarketOrder(rsl);
                add(item);
            });
        }});
        rsl.setCreated(orderDto.getCreated());
        rsl.setIsDone(false);
        return rsl;
    }

    public OrderDto convertToOrderDto(Order order) {
        OrderDto rsl = new OrderDto();
        rsl.setPrice(order.getPrice());
        rsl.setFullName(order.getFullName());
        rsl.setAddress(order.getAddress());
        rsl.setPhone(order.getPhone());
        rsl.setDeliveryMethodPay(order.getDeliveryMethodPay());
        rsl.setItems(new ArrayList<>() {{
            order.getItems().forEach(e -> {
                OrderItemDto item = new OrderItemDto();
                item.setName(e.getName());
                item.setPrice(e.getItemPrice());
                add(item);
            });
        }});
        rsl.setCreated(order.getCreated());
        rsl.setDone(false);
        return rsl;
    }

}
