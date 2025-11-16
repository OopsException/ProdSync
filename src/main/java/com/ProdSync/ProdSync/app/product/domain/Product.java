package com.ProdSync.ProdSync.app.product.domain;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import com.ProdSync.ProdSync.app.item.domain.Item;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "altName")
    private String altName;

    @Column(name = "serialNumber", unique = true, nullable = false)
    private Long serialNumber;

    @Column(name = "price", precision = 10, scale = 6, nullable = false)
    private BigDecimal price;

    @Column(name = "stockQuantity", nullable = false)
    private Integer stockQuantity;

    @ManyToMany
    @JoinTable(
            name = "product_item",
            joinColumns = @JoinColumn(name = "product"),
            inverseJoinColumns = @JoinColumn(name = "item")
    )
    private List<Item> items;
}
