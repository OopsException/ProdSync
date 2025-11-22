package com.ProdSync.ProdSync.app.offer.domain;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import com.ProdSync.ProdSync.app.product.domain.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "offer")
public class Offer extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sellingPrice", precision = 10, scale = 6, nullable = false)
    private BigDecimal sellingPrice;

	@Column(name = "targetCAC", precision = 10, scale = 6, nullable = false)
	private BigDecimal targetCAC;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product")
	private Product product;
}