package ru.job4j.order.mapper;

import org.springframework.stereotype.Component;
import ru.job4j.order.dto.OrderItemDto;
import ru.job4j.order.model.OrderItem;

@Component
public class ItemOrderMapper {

    public OrderItem mapperToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setName(orderItemDto.getName());
        orderItem.setItemPrice(orderItemDto.getPrice());
        return orderItem;
    }

    public OrderItemDto mapperToOrderItemDto(OrderItem orderItem) {
        OrderItemDto rsl = new OrderItemDto();
        rsl.setName(orderItem.getName());
        rsl.setPrice(orderItem.getItemPrice());
        return rsl;
    }

}
