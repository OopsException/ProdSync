package com.ProdSync.ProdSync.app.supplier.repository;

import com.ProdSync.ProdSync.app.supplier.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
