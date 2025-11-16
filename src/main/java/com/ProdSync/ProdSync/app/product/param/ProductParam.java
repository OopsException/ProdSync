package com.ProdSync.ProdSync.app.product.param;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductParam {
    private Integer id;
    private String name;
    private String altName;
    private Long serialNumber;
    private BigDecimal price;
    private Integer stockQuantity;
    private List<Integer> itemIds;
}
