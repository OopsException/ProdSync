package com.ProdSync.ProdSync.app.item.domain;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import com.ProdSync.ProdSync.app.product.domain.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "altName")
    private String altName;

    @Column(name = "serialNumber", unique = true, nullable = false)
    private Long serialNumber;

    @Column(name = "price", precision = 10, scale = 6, nullable = false)
    private BigDecimal price;

    @Column(name = "weight", precision = 10, scale = 6)
    private BigDecimal weight;

    @ManyToMany(mappedBy = "items")
    private List<Product> products;
}
