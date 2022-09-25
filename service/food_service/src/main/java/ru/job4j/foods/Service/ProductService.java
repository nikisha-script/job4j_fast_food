package ru.job4j.foods.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.foods.entity.product.Product;
import ru.job4j.foods.mapper.ProductMapper;
import ru.job4j.foods.model.product.ProductDto;
import ru.job4j.foods.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public Product create(ProductDto dto) {
        return productRepository.save(productMapper.mapToEntity(dto));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
