package ru.job4j.foods.entity.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.job4j.foods.entity.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "category")
    @OrderBy("title")
    private List<Product> products;

}
