package com.ProdSync.ProdSync.app.product.bean;

import com.ProdSync.ProdSync.app.item.bean.ItemBean;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBean {
    private Integer id;
    private String name;
    private String altName;
    private Long serialNumber;
    private BigDecimal price;
    private Integer stockQuantity;
    private List<ItemBean> items;
}
