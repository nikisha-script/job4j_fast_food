package ru.job4j.foods.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.foods.entity.category.Category;
import ru.job4j.foods.model.caregory.CategoryDto;
import ru.job4j.foods.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(String title) {
        Category category = new Category();
        category.setTitle(title);
        return categoryRepository.save(category);
    }

    public Category create(CategoryDto dto) {
        Category category = new Category();
        category.setTitle(dto.getTitle());
        return categoryRepository.save(category);
    }

}
