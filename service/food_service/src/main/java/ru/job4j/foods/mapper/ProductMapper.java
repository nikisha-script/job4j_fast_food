package ru.job4j.foods.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.job4j.foods.Service.CategoryService;
import ru.job4j.foods.entity.category.Category;
import ru.job4j.foods.entity.product.Product;
import ru.job4j.foods.model.product.ProductDto;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryService categoryService;

    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            dto.setCategoryTitle(product.getCategory().getTitle());
        }
        return dto;
    }

    public Product mapToEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        if (dto.getCategoryTitle() != null) {
            categoryService.findByTitle(dto.getCategoryTitle())
                    .ifPresentOrElse(
                            product::setCategory,
                            () -> {
                                Category newCategory = categoryService.create(dto.getCategoryTitle());
                                product.setCategory(newCategory);
                            }
                    );
        }
        return product;
    }

}
