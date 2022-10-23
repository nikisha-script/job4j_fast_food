package ru.job4j.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.dto.ApiDtoOrders;
import ru.job4j.order.model.Order;
import ru.job4j.order.model.OrderItem;
import ru.job4j.order.service.OrderItemService;
import ru.job4j.order.service.OrderService;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @PostMapping
    public Order createOrder(@RequestBody ApiDtoOrders apiOrder) {
        Order rsl = new Order();
        List<OrderItem> items = new ArrayList<>();
        apiOrder.getItems().forEach(e -> {
            OrderItem item = new OrderItem();
            item.setName(e.getName());
            item.setItemPrice(e.getPrice());
            items.add(item);
        });
        rsl.setPrice(apiOrder.getPrice());
        rsl.setFullName(apiOrder.getFullName());
        rsl.setAddress(apiOrder.getAddress());
        rsl.setPhone(apiOrder.getPhone());
        rsl.setDeliveryMethodPay(apiOrder.getDeliveryMethodPay());
        rsl.setItems(items);
        rsl.setCreated(LocalDateTime.now());
        rsl.setIsDone(false);
        Order saveOrder = orderService.save(rsl);
        items.forEach(e -> {
            e.setMarketOrder(saveOrder);
            orderItemService.save(e);
        });
        return saveOrder;
    }

    @GetMapping("{id}")
    public Order findOrderById(@PathVariable(name = "id") Long id) {
        return orderService.findById(id)
                .orElseThrow(EntityExistsException::new);
    }
}
