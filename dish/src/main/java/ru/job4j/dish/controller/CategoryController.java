package ru.job4j.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.dto.CategoryDto;
import ru.job4j.dish.model.Category;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.CategoryService;
import ru.job4j.dish.util.CreateCategory;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;
    private final CreateCategory createCategory;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/dishes")
    public List<Dish> getDishes(@RequestParam(name = "id") Long id) {
        Category category = categoryService.findById(id).orElseThrow(() -> new EntityNotFoundException("Caregory " + id + " is not found"));
        return category.getDishes();
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable(name = "categoryId") Long categoryId) {
        return categoryService.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category " + categoryId + " is not found"));
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryDto categoryDto) throws IOException {
        Category category = createCategory.created(categoryDto.getName(), categoryDto.getPath());
        return categoryService.create(category);
    }

}
