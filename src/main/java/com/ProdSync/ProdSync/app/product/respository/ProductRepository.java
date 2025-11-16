package com.ProdSync.ProdSync.app.product.respository;

import com.ProdSync.ProdSync.app.item.domain.Item;
import com.ProdSync.ProdSync.app.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findBySerialNumber(Long serialNumber);
}
