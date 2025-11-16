package com.ProdSync.ProdSync.app.supplier.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierBean {
    private Integer id;
    private String name;
    private String altName;
    private String shopLink;
}
