package com.ProdSync.ProdSync.app.supplier.domain;

import com.ProdSync.ProdSync.app.abstractEntity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "supplier")
public class Supplier extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "altName")
    private String altName;

    @Column(name = "shopLink")
    private String shopLink;
}
