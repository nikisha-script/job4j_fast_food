package ru.job4j.dish.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.job4j.dish.dto.DishDto;
import ru.job4j.dish.entity.Category;
import ru.job4j.dish.entity.Dish;
import ru.job4j.dish.service.CategoryService;

@Component
@RequiredArgsConstructor
public class DishMapper {

    private final CategoryService categoryService;

    public Dish mapToEntity(DishDto dish) {
        Dish rsl = new Dish();
        rsl.setId(dish.getId());
        rsl.setName(dish.getName());
        rsl.setCost(dish.getCost());
        if (dish.getCategoryName() != null) {
            categoryService.findByTitle(dish.getCategoryName()).ifPresentOrElse(rsl::setCategory,
                    () -> {
                        Category category = categoryService.create(dish.getCategoryName());
                        rsl.setCategory(category);
                    });
        }

        return rsl;
    }
}
