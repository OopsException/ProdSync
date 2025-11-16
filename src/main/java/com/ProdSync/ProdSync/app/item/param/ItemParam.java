package com.ProdSync.ProdSync.app.item.param;

import com.ProdSync.ProdSync.app.product.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ItemParam {
    private Integer id;
    private String name;
    private String altName;
    private Long serialNumber;
    private BigDecimal price;
    private BigDecimal weight;
}
