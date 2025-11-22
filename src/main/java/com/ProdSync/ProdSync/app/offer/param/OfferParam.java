package com.ProdSync.ProdSync.app.offer.param;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OfferParam {
	private Integer id;
	private String name;

	private BigDecimal sellingPrice;
	private BigDecimal targetCAC;

	private Integer quantity;
	private Integer productId;
}