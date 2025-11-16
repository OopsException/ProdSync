package com.ProdSync.ProdSync.app.productItemMapping;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import com.ProdSync.ProdSync.app.item.domain.Item;
import com.ProdSync.ProdSync.app.product.domain.Product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_item_mapping")
public class ProductItemMapping extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "item", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantity;
}