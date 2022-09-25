package ru.job4j.orders.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String name;

    @Column
    private Integer count;

    @Column
    private Double itemPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private MarketOrder marketOrder;


}
