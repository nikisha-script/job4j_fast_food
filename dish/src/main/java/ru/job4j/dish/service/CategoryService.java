package ru.job4j.dish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.dto.CategoryDto;
import ru.job4j.dish.store.CategoryRepository;
import ru.job4j.dish.entity.Category;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<Category> findByName(String title) {
        return categoryRepository.findByName(title);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

}
