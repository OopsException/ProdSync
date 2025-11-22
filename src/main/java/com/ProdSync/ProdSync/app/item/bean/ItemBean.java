package com.ProdSync.ProdSync.app.item.bean;

import com.ProdSync.ProdSync.app.costConstants.CostConstants;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemBean {
    private Integer id;
    private String name;
    private String altName;
    private Long serialNumber;
    private BigDecimal price;
    private BigDecimal weight;
    private Integer quantity;
    private Integer supplierId;
    private String supplierName;

	private BigDecimal shippingCost;
	private BigDecimal landedCost;

	public void calculateCosts() {
		BigDecimal qty = BigDecimal.valueOf(quantity);
		BigDecimal weightKg = weight.divide(BigDecimal.valueOf(1000), 6, RoundingMode.HALF_UP);
		BigDecimal shippingPerUnit = weightKg.multiply(CostConstants.FIXED_SHIPPING_COST);

		this.shippingCost = shippingPerUnit.multiply(qty);
		this.landedCost = price.add(shippingPerUnit).multiply(qty);
	}
}
