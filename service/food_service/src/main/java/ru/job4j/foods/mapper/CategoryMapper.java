package ru.job4j.foods.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.job4j.foods.entity.category.Category;
import ru.job4j.foods.model.caregory.CategoryDto;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {

    CategoryDto map(Category source);
}
