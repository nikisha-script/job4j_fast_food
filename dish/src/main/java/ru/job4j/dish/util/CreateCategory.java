package ru.job4j.dish.util;

import org.springframework.stereotype.Component;
import ru.job4j.dish.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CreateCategory {

    public Category created(String name, Path path) throws IOException {
        Category category = new Category();
        byte[] images = Files.readAllBytes(Paths.get(String.valueOf(path)).toAbsolutePath());
        category.setName(name);
        category.setImg(images);
        return category;
    }

}
