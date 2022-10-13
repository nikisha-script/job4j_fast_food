package ru.job4j.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.dto.CategoryDto;
import ru.job4j.dish.service.CategoryService;
import ru.job4j.dish.entity.Category;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.findAll()
                .stream()
                .map(e -> CategoryDto.builder()
                        .name(e.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable(name = "categoryId") Long categoryId) {
        return categoryService.findById(categoryId)
                .map(e -> CategoryDto.builder()
                        .name(e.getName())
                        .build())
                .orElseThrow(() -> new EntityNotFoundException("Category " + categoryId + " is not found"));
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

}
