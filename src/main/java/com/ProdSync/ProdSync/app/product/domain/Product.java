package com.ProdSync.ProdSync.app.product.domain;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import com.ProdSync.ProdSync.app.productItemMapping.ProductItemMapping;
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

	public Product(Integer id) {
		this.setId(id);
	}

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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductItemMapping> productItems;
}