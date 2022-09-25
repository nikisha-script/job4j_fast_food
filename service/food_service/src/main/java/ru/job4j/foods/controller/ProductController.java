package ru.job4j.foods.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.foods.Service.OrderService;
import ru.job4j.foods.Service.ProductService;
import ru.job4j.foods.mapper.ProductMapper;
import ru.job4j.foods.model.product.ProductDto;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final OrderService orderService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts().stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto product) {
        return productMapper.mapToDto(productService.create(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PostMapping("/orders")
    public String sendToOrder(@RequestBody List<ProductDto> products) {
        return orderService.sendProductsToOrders(products);
    }

}
