package ru.job4j.foods.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.foods.Service.CategoryService;
import ru.job4j.foods.mapper.CategoryMapper;
import ru.job4j.foods.model.caregory.CategoryDto;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.findAll()
                .stream()
                .map(e -> CategoryDto.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable(name = "categoryId") Long categoryId) {
        return categoryService.findById(categoryId)
                .map(e -> CategoryDto.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .build())
                .orElseThrow(() -> new EntityNotFoundException("Category " + categoryId + " is not found"));
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto category) {
        return categoryMapper.map(categoryService.create(category));
    }

}
